/*package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class DeleteBoardController { //implements Controller

	//annotation ver.
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	/*
	 * @Override public ModelAndView handleRequest(HttpServletRequest request,
	 * HttpServletResponse response) {
	 * 
	 * System.out.println("글 삭제 처리");
	 * 
	 * // 1. 사용자 입력 정보 추출 String seq= request.getParameter("seq");
	 * 
	 * // 2. DB 연동 처리 BoardVO vo = new BoardVO(); vo.setSeq(Integer.parseInt(seq));
	 * 
	 * BoardDAO boardDAO = new BoardDAO(); boardDAO.deleteBoard(vo);
	 * 
	 * // 3. 화면 내비게이션 ModelAndView mav = new ModelAndView();
	 * //mav.setViewName("getBoardList.do");
	 * 
	 * //ViewResolver사용을 위한 변경 mav.setViewName("redirect:getBoardList.do"); return
	 * mav;
	 * 
	 * //return "getBoardList.do"; }
	 */

//}
