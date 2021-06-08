/*package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
//import org.springframework.web.servlet.mvc.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateBoardController { //implements Controller 

	//annotation ver.
	@RequestMapping("/updateBoard.do")
	public String updateBoard (BoardVO vo, BoardDAO boardDAO) {
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	/*
	 * @Override public ModelAndView handleRequest(HttpServletRequest request,
	 * HttpServletResponse response) { System.out.println("�� ���� ó��");
	 * 
	 * // 1. ����� �Է����� ����
	 * 
	 * doPost()���� request.setCharacterEncoding("EUC-KR") �����ϹǷ� ���⼭ �ߺ����� �� �ʿ䰡 ����.
	 * request.setCharacterEncoding("EUC-KR");
	 * 
	 * 
	 * String title = request.getParameter("title"); String content =
	 * request.getParameter("content"); String seq = request.getParameter("seq");
	 * 
	 * // 2. DB ���� ó�� BoardVO vo = new BoardVO(); vo.setTitle(title);
	 * vo.setContent(content); vo.setSeq(Integer.parseInt(seq));
	 * 
	 * BoardDAO boardDAO = new BoardDAO(); boardDAO.updateBoard(vo);
	 * 
	 * // 3. ȭ�� �׺���̼� ModelAndView mav = new ModelAndView();
	 * //mav.setViewName("getBoardList.do");
	 * 
	 * //ViewResolver����� ���� ���� mav.setViewName("redirect:getBoardList.do"); return
	 * mav;
	 * 
	 * // �� ���� �� ������� ���� �� BoardList�� ������� �ϹǷ� .do //return "getBoardList.do"; }
	 */

//}
