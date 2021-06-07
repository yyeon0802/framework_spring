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
		
		//이제 부터 Session이 아닌 Httprequest 로 부터 정보를 가져올 수 있다.
		
		System.out.println("글 상세 조회 처리");
		
		// 1. 검색할 게시글 번호 추출
		String seq = request.getParameter("seq");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		System.out.println(board);
	
		// 3. 검색 결과를 세션에 저장하고 상세 화면으로 이동한다. => 검색결과와 화면정보를 ModelAndView에 저장하여 리턴한다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board); 		// Model에 정보 저장
		//mav.setViewName("getBoard.jsp");	// View에 정보 저장
		
		//ViewResolver사용을 위한 변경
		mav.setViewName("getBoard");

		return mav;
		
		/* Session은 요청할때마다 하나씩 새로 생성된다. 이에 서버에 과부하가 올 수 있으므로 권장하지 XXX
		 * HttpSession session = request.getSession(); session.setAttribute("board",
		 * board); return "getBoard";
		 */
	}

}
