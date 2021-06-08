/*package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
//import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping; //doPost의 직접적인 메소드 mapping

/* 스프링 컨테이너 관점 :
 * 	글 등록 정보를 적절하게 입력 -> 서버에 insertBoard.do요청 전달 -> 컨테이너는 @Controller가 붙은 모든 컨트롤러 객체를 생성 ->
 *  InsertBoardController가 가지고 있는 insertBoard()메소드를 실행 -> 
 *  이때 매개변수에 해당하는 BoardVO객체를 스프링컨테이너가 생성하여 전달*/

//@Controller //container 객체 자동생성
//public class InsertBoardController  { // implements Controller
		
	//FINAL : annotation ver.
	
	//@Override -> 상속 받은 것이 아니라 삭제
	
	// 아래의 설정은, 클라이언트로부터 "/insertBoard.do"라는 요청이 올때 insertBoard() 라는 method를 mapping하겠다는 설정.
	//객체가 아닌 doPost의 직접적인 method(= insertBoard() )를 ! mapping / value 생략가능(대부분 생략)
	//@RequestMapping(value="/insertBoard.do") 
	//public String  insertBoard(BoardVO vo, BoardDAO boardDAO) { 
		
		//annotation ver. 매개변수 BoardDAO boardDAO 추가 -> void => String 수정
		
		//ModelAndView -> void로 변경 / 메소드명 handleRequest 변경 -> insertBoard
	
		// 매개변수 HttpServletResponse response 삭제
		// HttpServletRequest request 매개변수로 받지 말고 바로 BoardVO를 받아 command객체 사용
		
		//System.out.println("글 등록 처리");
		
		//boardDAO.insertBoard(vo);
		//return "getBoardList.do";
		
		//view 경로를 리턴하면 기본적으로 포워딩 방식이므로, 리다이렉트를 원할때는 redirect접두사를 붙여 넘겨야 한다.
		//아래 소스는 글 등록 처리 후 "getUserList.do"로 리다이렉트 되어 최종 url은 다음과 같다.
		// =>http://localhost:8090/BoardWeb/getBoardList.do
		//return "redirect:getBoardList.do";
		
		
		// 1. 사용자 입력 정보 추출
		
		//String title = request.getParameter("title");
		//String writer = request.getParameter("writer");
		//String content = request.getParameter("content");
		
		// 2. DB 연동 처리
		//BoardVO vo = new BoardVO();
		//vo.setTitle(title);
		//vo.setWriter(writer);
		//vo.setContent(content);
		
		//BoardDAO boardDAO = new BoardDAO();
		//매개변수로 BoardVO vo를 바로 받을경우, insertBoard()실행시 command 객체가 자동으로 추출, 연동까지 setting함
		
		/* 서블릿 컨테이너는 클라이언트의 http요청이 서버에 전달되는 순간,
		 * HttpServletRequest 객체를 생성하고 http프로토콜에 설정된 모든 정보를 추출하여 HttpServletRequest 객체에 저장한다.
		 * 이 HttpServletRequest 객체를 service() 메소드를 호출할때, 인자로 전달 한다.*/
		
		
		// annotation 사용으로 화면 내비게이션 부분 삭제
		
		// 3. 화면 내비게이션
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("getBoardList.do");
		
		//ViewResolver사용을 위한 변경
		//mav.setViewName("redirect:getBoardList.do");
		//return mav;
		
		//등록한 글을 포함하여 재검색 후 BoadList를 출력 해야 하므로 .do	
		//return "getBoardList.do";
	//}

//}
