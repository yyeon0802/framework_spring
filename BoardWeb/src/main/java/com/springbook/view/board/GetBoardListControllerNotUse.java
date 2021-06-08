/*package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class GetBoardListController  { //implements Controller

	//annotation ver.
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		mav.addObject("boardList", boardDAO.getBoardList(vo)); //Model ���� ����
		mav.setViewName("getBoardList.jsp"); // view ���� ����
		return mav;
	}

	
	/*public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ��� �˻� ó��");

		// 1. ����� �Է� ���� ����(�˻������ ���Ŀ� ����)
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);

		// 3. �˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵��Ѵ�. => �˻������ ȭ�������� ModleAndView�� �����Ͽ� �����Ѵ�.
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); 	// Model ���� ����
		//mav.setViewName("getBoardList.jsp"); 	// View ���� ����
		
		//ViewResolver����� ���� ����
		mav.setViewName("getBoardList");
		return mav;
		
		
		 * HttpSession session = request.getSession(); session.setAttribute("boardList",
		 * boardList);
		 * 
		 * return "getBoardList";
		 
	}*/
	

//}
