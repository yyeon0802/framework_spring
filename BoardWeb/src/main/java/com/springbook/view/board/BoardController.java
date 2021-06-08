package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board") //null������Ʈ ���� SessionAttributes ��� => ��, session�� board��� ��ü�� ����Ǿ� ������ ����ϰڴ�.
public class BoardController {
	
	/* return type ��
	 *  1) ModelAndView : �˻��� Model(������)�� View �̸�(���ڿ� �̸�)�� ��� ����(ex.mav)�Ͽ� return
	 *  2) String 		: �Ϻ��� View�̸��� ��� �����Ͽ� return <�����Ͽ� �ַ� �̿�>
	 * */

	// �۵�� �ϱ�
	@RequestMapping(value="/insertBoard.do") 
	public String  insertBoard(BoardVO vo, BoardDAO boardDAO) { 
		
		System.out.println("�� ��� ó��");
		boardDAO.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	/*���� �Ķ���� ������ ���� ���� ������(ex.������ writer����) null�� ���޵Ǿ� ������ �ȴ�. 
		�̸� �����ϱ� ���� SessionAttribute�� ����ڰ� �Է��� ������ �����Ѵ�. 
	*/
	// �� ����
	@RequestMapping("/updateBoard.do")
	public String updateBoard (@ModelAttribute("board")BoardVO vo, BoardDAO boardDAO) {
		//System.out.println("�ۼ��� �̸� : " + vo.getWriter());
		System.out.println("�� ���� ó��");
		System.out.println("��ȣ : " + vo.getSeq());
		System.out.println("���� : " + vo.getTitle());
		System.out.println("���� : " + vo.getContent());
		System.out.println("����� : " + vo.getRegDate());
		System.out.println("��ȸ�� : " + vo.getCnt());		
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// �� ����
		@RequestMapping("/deleteBoard.do")
		public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
			
			boardDAO.deleteBoard(vo);
			return "getBoardList.do";
		}
	
	// �� �� ��ȸ
		@RequestMapping("/getBoard.do")
		public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) { // ModelAndView getBoard(����, ModelAndView mav)
			model.addAttribute("board", boardDAO.getBoard(vo)); 	// Model���� ���� : "board"�� ����(���� �� ����ȸ�� ���� �޼ҵ� ���� ���� ����Ǽ� ��â���� ���������ϴ�)
			return "getBoard.jsp";		// view �̸� ����
			
			/*mav.addObject("board", boardDAO.getBoard(vo)); //Model ���� ����
			  mav.setViewName("getBoard.jsp"); //view ���� ���� 
			  return mav;*/
			
			
		}
	
	
	/* ModelAttrubute 2) View(JSP)���� ����� �����͸� �����ϴ� �뵵
	 *  - �����ϰԵǸ�, @RequestMapping ������̼��� ����� �޼ҵ� ���� ���� ȣ�� 
	 *  - @ModelAttribute�� ���� ����� ���ϵ� ��ü�� �ڵ����� Model�� ���� => �������� ���ϵ� ��ü�� View���������� ��� ����
	 *  ex) model ��ü�� : { conditionMap(������)  : {"����" : "TITLE"}, 
	 *  										{"����" : "CONTENT"} } ,
	 *  				{boardList : { {seq,title, writer, content} , 
	 *  								{seq,title, writer, content}  ... }
	*/	
		
	// �˻� ���� ��� ����
		@ModelAttribute("conditionMap")
		public Map<String, String> searchConditionMap() {
			Map<String, String> conditionMap = new HashMap<String, String>();
			conditionMap.put("����", "TITLE");
			conditionMap.put("����", "CONTENT");
			return conditionMap;
		}
		
		@RequestMapping("/getBoardList.do")
		 public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) { // ModelAndView getBoardList(����, ModelAndView mav)
			
			model.addAttribute("boardList", boardDAO.getBoardList(vo));	 // Model ���� ����
			return "getBoardList.jsp";			// view �̸� ����
			 
		}
		
		/* Command ��ü�� ����Ϸ��� ��û �Ķ���Ϳ� ���ε� ������ Setter �޼ҵ尡 Command Ŭ������ ����Ǿ� �־�� �Ѵ�.
		 * �ٸ�, command��ü�� ���� �Ķ���͸� Controller Ŭ�������� ����Ϸ���,(ex.private String keyword����, getter/setter ����)
		 *  1) VO�� �ش� Ŭ������ ���ư� ���� �߰� �� getter/setter �޼ҵ� ����
		 *  2) @RequestParam�� ���Ͽ� Command Ŭ������ ���� �Ķ���� ������ ������ �� �ִ�. �۸�� �˻��� ���,
		 * 
		 * @RequestParma(value="searchCondition", 	=> value : ȭ�����κ��� ���޵� �Ķ���� �̸�
		 * 				defaultValue="TITLE",		=> defaultVale : ȭ�����κ��� ���޵� �Ķ���� ������ ������, ������ �⺻��
		 * 				required=false) String condition => required : �Ķ������ ���� ���� 
		 * */ 
	
		//�� ��� �˻� : @RequestParam �̿� ver.
		
		//@RequestMapping("/getBoardList.do")
		/* public String getBoardList(
				@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
				@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
				BoardVO vo, BoardDAO boardDAO, Model model) { // ModelAndView getBoardList(����, ModelAndView mav)
			
			System.out.println("�˻� ���� : " + condition);
			System.out.println("�˻� �ܾ� : " + keyword);
			// Model ���� ����
			model.addAttribute("boardList", boardDAO.getBoardList(vo));	
			return "getBoardList.jsp";			// view �̸� ����
			
			/*
			 * mav.addObject("boardList", boardDAO.getBoardList(vo)); //Model ���� ����
			 * mav.setViewName("getBoardList.jsp"); // view ���� ���� return mav;
			 */
		//}
		
}
