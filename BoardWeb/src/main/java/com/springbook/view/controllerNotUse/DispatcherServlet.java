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
	// MVC pattern �߰�
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;

	// MVC pattern => handlerMapping�� viewResolver�� ����ϱ� ���� �����̳� ������ �ڵ����� ������ init();
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping(); 	//	�ʱ�ȭ
		viewResolver = new ViewResolver();		// �ʱ�ȭ
		viewResolver.setPrefix("./");			//setting
		viewResolver.setSuffix(".jsp");			//setting

	}

	// �⺻������ ���� ����
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
		// MVC pattern => handlerMapping�� viewResolver�� ����ϱ� ���� ����
		
		// 1. Ŭ���̾�Ʈ�� ��û path ������ �����Ѵ�.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")); // ȣ���� path ���� ��´�.
		// => uri=/BoardWeb/login.do
		System.out.println(path);
		
		// 2. HandlerMapping�� ���� path�� �ش��ϴ� Controller�� �˻��Ѵ�.
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. �˻��� Controller�� �����Ѵ�. => "login"�̶�� String���� viewName�� ��´�.
		String viewName = ctrl.handleRequest(request, response);
		// �α��� ���� viewName = "login"
		// �α��� ���� viewName = "getBoardList.do"
		
		// 4. ViewResolver�� ���� viewName�� �ش��ϴ� ȭ���� �˻��Ѵ�.
		String view = null;
		if(!viewName.contains(".do")) {
			// �α��� ���� (.do�� ���� ���) ./ �� jsp �� �ٿ� view��
			// view = "./login.jsp"
			view = viewResolver.getView(viewName);
		} else {
			// �α��� ���� view = getBoardList.do
			view = viewName;			
		}
		
		// 5. �˻��� ȭ������ �̵��Ѵ�.
		//.do ȣ�� -> doGet�Լ��� request�� �޾Ƶ鿩��
		response.sendRedirect(view);
	}	
		
		/*// 1. Ŭ���̾�Ʈ�� ��û path ������ �����Ѵ�.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);

		// 2. Ŭ���̾�Ʈ�� ��û path�� ���� ������ �б� ó���� �Ѵ�.
		if (path.equals("/login.do")) {
			System.out.println("�α��� ó��");

			// 1. ����� �Է� ���� ����
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			// 2. DB ���� ó��
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);

			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);

			// 3. ȭ�� �׺���̼�
			if (user != null) {
				 �۸���� ����Ϸ��� getBoardList�� ���� ��û���� �ʰ�, getBoardList.do�� ��û�ؾ� �Ѵ�.
				 * DispatcherServlet�� Ŭ���̾�Ʈ�� "/getBoardList.do" ��û�� ������,
				 * DispatcherServlet�� BoardDAO ��ü�� �̿��� �� ����� �˻� ��,
				 * �˻��� �� ����� ���ǿ� ��� �ϰ�, getBoardList.jsp ȭ���� ��û �Ŀ�
				 * getBoardList.jsp�� ���ǿ� ����� �� ����� ������ ��� ȭ���� �����Ѵ�.
				 * ���������� ! �� ����ȭ���� [������]�� ���۵Ǵ� �����̴�.
				
//				response.sendRedirect("getBoardList.jsp");
				response.sendRedirect("getBoardList.do");
			} else {
				// DB�� java source�� ������ �ʿ��Ҷ� -> jsp
				// ȭ�� ����� �ʿ��� �� -> .do => �� else ������ .do�� ���� ���� ������ ������ �ȴ�(why? ���� id, pw = null)
				response.sendRedirect("login.jsp");
			}

		} else if (path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
			
			// 1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
			HttpSession session = request.getSession();
			session.invalidate();

			// 2. ���� ���� ��, ����ȭ������ ���ư���.
			response.sendRedirect("login.jsp");
//			response.sendRedirect("login.do"); -> ���� �α׾ƿ� ���¶�, id pw�� null���̹Ƿ� login.do ������ else���� ����Ͽ� login.jsp�� ������.

		} else if (path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ó��");
			
			// 1. ����� �Է� ���� ����
			
			doPost()���� request.setCharacterEncoding("EUC-KR") �����ϹǷ� ���⼭ �ߺ����� �� �ʿ䰡 ����.
			request.setCharacterEncoding("EUC-KR");
			
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			// 3. ȭ�� ������̼�
			response.sendRedirect("getBoardList.do");

		} else if (path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ó��");
			
			// 1. ����� �Է����� ����
			
			doPost()���� request.setCharacterEncoding("EUC-KR") �����ϹǷ� ���⼭ �ߺ����� �� �ʿ䰡 ����.
			request.setCharacterEncoding("EUC-KR");
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			// 3. ȭ�� �׺���̼�
			response.sendRedirect("getBoardList.do");

		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ó��");
			
			// 1. ����� �Է� ���� ����
			String seq= request.getParameter("seq");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			// 3. ȭ�� ������̼�
			response.sendRedirect("getBoardList.do");

		} else if (path.equals("/getBoard.do")) {
			System.out.println("�� �� ��ȸ ó��");
			
			// 1. �˻��� �Խñ� ��ȣ ����
			String seq = request.getParameter("seq");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
		
			// 3. �˻� ����� ���ǿ� �����ϰ� �� ȭ������ �̵��Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");

		} else if (path.equals("/getBoardList.do")) {
			System.out.println("�� ��� �˻� ó��");

			// 1. ����� �Է� ���� ����(�˻������ ���Ŀ� ����)
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);

			// 3. �˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵��Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");

		}
	}*/
	
}
