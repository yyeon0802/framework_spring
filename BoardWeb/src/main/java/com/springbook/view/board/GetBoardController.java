package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		//���� ���� Session�� �ƴ� Httprequest �� ���� ������ ������ �� �ִ�.
		
		System.out.println("�� �� ��ȸ ó��");
		
		// 1. �˻��� �Խñ� ��ȣ ����
		String seq = request.getParameter("seq");
		
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		System.out.println(board);
	
		// 3. �˻� ����� ���ǿ� �����ϰ� �� ȭ������ �̵��Ѵ�. => �˻������ ȭ�������� ModelAndView�� �����Ͽ� �����Ѵ�.
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board); 		// Model�� ���� ����
		//mav.setViewName("getBoard.jsp");	// View�� ���� ����
		
		//ViewResolver����� ���� ����
		mav.setViewName("getBoard");

		return mav;
		
		/* Session�� ��û�Ҷ����� �ϳ��� ���� �����ȴ�. �̿� ������ �����ϰ� �� �� �����Ƿ� �������� XXX
		 * HttpSession session = request.getSession(); session.setAttribute("board",
		 * board); return "getBoard";
		 */
	}

}
