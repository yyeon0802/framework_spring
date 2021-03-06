package com.springbook.view.controllerNotUse;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// MVC pattern 추가
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;

	// MVC pattern => handlerMapping과 viewResolver를 사용하기 위한 컨테이너 구동시 자동으로 실행할 init();
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping(); 	//	초기화
		viewResolver = new ViewResolver();		// 초기화
		viewResolver.setPrefix("./");			//setting
		viewResolver.setSuffix(".jsp");			//setting

	}

	// 기본생성자 삭제 가능
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	/*
	 * public DispatcherServlet() { super(); // TODO Auto-generated constructor stub
	 * }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// MVC pattern => handlerMapping과 viewResolver를 사용하기 위한 수정
		
		// 1. 클라이언트의 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")); // 호출한 path 값을 담는다.
		// => uri=/BoardWeb/login.do
		System.out.println(path);
		
		// 2. HandlerMapping을 통해 path에 해당하는 Controller를 검색한다.
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. 검색된 Controller를 실행한다. => "login"이라는 String값을 viewName에 담는다.
		String viewName = ctrl.handleRequest(request, response);
		// 로그인 실패 viewName = "login"
		// 로그인 성공 viewName = "getBoardList.do"
		
		// 4. ViewResolver를 통해 viewName에 해당하는 화면을 검색한다.
		String view = null;
		if(!viewName.contains(".do")) {
			// 로그인 실패 (.do가 없는 경우) ./ 와 jsp 를 붙여 view에
			// view = "./login.jsp"
			view = viewResolver.getView(viewName);
		} else {
			// 로그인 성공 view = getBoardList.do
			view = viewName;			
		}
		
		// 5. 검색된 화면으로 이동한다.
		//.do 호출 -> doGet함수의 request로 받아들여짐
		response.sendRedirect(view);
	}	
		
		/*// 1. 클라이언트의 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);

		// 2. 클라이언트의 요청 path에 따라 적절히 분기 처리를 한다.
		if (path.equals("/login.do")) {
			System.out.println("로그인 처리");

			// 1. 사용자 입력 정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			// 2. DB 연동 처리
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);

			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);

			// 3. 화면 네비게이션
			if (user != null) {
				 글목록을 출력하려면 getBoardList를 직접 요청하지 않고, getBoardList.do를 요청해야 한다.
				 * DispatcherServlet이 클라이언트의 "/getBoardList.do" 요청을 받으면,
				 * DispatcherServlet은 BoardDAO 객체를 이용해 글 목록을 검색 후,
				 * 검색된 글 목록을 세션에 등록 하고, getBoardList.jsp 화면을 요청 후에
				 * getBoardList.jsp는 세션에 저장된 글 목록을 꺼내어 목록 화면을 구성한다.
				 * 마지막으로 ! 이 응답화면이 [브라우저]에 전송되는 형식이다.
				
//				response.sendRedirect("getBoardList.jsp");
				response.sendRedirect("getBoardList.do");
			} else {
				// DB와 java source와 연동이 필요할때 -> jsp
				// 화면 출력이 필요할 때 -> .do => 현 else 문에서 .do로 가면 무한 루프에 빠지게 된다(why? 현재 id, pw = null)
				response.sendRedirect("login.jsp");
			}

		} else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			
			// 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
			HttpSession session = request.getSession();
			session.invalidate();

			// 2. 세션 종료 후, 메인화면으로 돌아간다.
			response.sendRedirect("login.jsp");
//			response.sendRedirect("login.do"); -> 현재 로그아웃 상태라, id pw가 null값이므로 login.do 로직의 else문을 통과하여 login.jsp로 보낸다.

		} else if (path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
			
			// 1. 사용자 입력 정보 추출
			
			doPost()에서 request.setCharacterEncoding("EUC-KR") 실행하므로 여기서 중복으로 할 필요가 없다.
			request.setCharacterEncoding("EUC-KR");
			
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			// 3. 화면 내비게이션
			response.sendRedirect("getBoardList.do");

		} else if (path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			
			// 1. 사용자 입력정보 추출
			
			doPost()에서 request.setCharacterEncoding("EUC-KR") 실행하므로 여기서 중복으로 할 필요가 없다.
			request.setCharacterEncoding("EUC-KR");
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");

		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			
			// 1. 사용자 입력 정보 추출
			String seq= request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			// 3. 화면 내비게이션
			response.sendRedirect("getBoardList.do");

		} else if (path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");
			
			// 1. 검색할 게시글 번호 추출
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
		
			// 3. 검색 결과를 세션에 저장하고 상세 화면으로 이동한다.
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");

		} else if (path.equals("/getBoardList.do")) {
			System.out.println("글 목록 검색 처리");

			// 1. 사용자 입력 정보 추출(검색기능은 추후에 구현)
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);

			// 3. 검색 결과를 세션에 저장하고 목록 화면으로 이동한다.
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");

		}
	}*/
	
}
