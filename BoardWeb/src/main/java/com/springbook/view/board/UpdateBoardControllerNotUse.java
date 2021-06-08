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
	 * HttpServletResponse response) { System.out.println("글 수정 처리");
	 * 
	 * // 1. 사용자 입력정보 추출
	 * 
	 * doPost()에서 request.setCharacterEncoding("EUC-KR") 실행하므로 여기서 중복으로 할 필요가 없다.
	 * request.setCharacterEncoding("EUC-KR");
	 * 
	 * 
	 * String title = request.getParameter("title"); String content =
	 * request.getParameter("content"); String seq = request.getParameter("seq");
	 * 
	 * // 2. DB 연동 처리 BoardVO vo = new BoardVO(); vo.setTitle(title);
	 * vo.setContent(content); vo.setSeq(Integer.parseInt(seq));
	 * 
	 * BoardDAO boardDAO = new BoardDAO(); boardDAO.updateBoard(vo);
	 * 
	 * // 3. 화면 네비게이션 ModelAndView mav = new ModelAndView();
	 * //mav.setViewName("getBoardList.do");
	 * 
	 * //ViewResolver사용을 위한 변경 mav.setViewName("redirect:getBoardList.do"); return
	 * mav;
	 * 
	 * // 글 수정 후 내용까지 저장 후 BoardList를 보여줘야 하므로 .do //return "getBoardList.do"; }
	 */

//}
