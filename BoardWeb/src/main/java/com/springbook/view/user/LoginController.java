package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController  { //implements Controller

	//ModelAttribute 1) : controller �޼ҵ��� �Ű������� ����� Command��ü�� �̸��� �����Ҷ� ���(ex. UserVO => user) 
	
	//annotation ver. controller ���� => ModelAttribute ��� 
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user")UserVO vo) { //UserVO vo
		System.out.println("�α��� ó��");
		System.out.println("�α��� ȭ������ �̵�");
		vo.setId("test");
		vo.setPassword("test1234");
		return "login.jsp";
	}
	
	//servlet API ���
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		
		//����ó�� 1)
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("���̵�� �ݵ�� �Է��ؾ��մϴ�.");
		}
		UserVO user = userDAO.getUser(vo);
		
		System.out.println("�α��� ó��");
		System.out.println("�α��� ���� ó��...");
		
		if(userDAO.getUser(vo) != null) {
			// parameter�� session�� {"userName" : "������"} => key:value�� mapping�� �ϳ��� ������ ����
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
	
	/*
	 * @RequestMapping("/login.do") public String login(UserVO vo, UserDAO userDAO)
	 * { if(userDAO.getUser(vo) != null) return "getBoardList.do"; else return
	 * "login.jsp"; }
	 */
	
	
	/*
	 * @Override public ModelAndView handleRequest(HttpServletRequest request,
	 * HttpServletResponse response) { System.out.println("�α��� ó��");
	 * 
	 * // 1. ����� �Է� ���� ���� String id = request.getParameter("id"); String password =
	 * request.getParameter("password");
	 * 
	 * // 2. DB ���� ó�� UserVO vo = new UserVO(); vo.setId(id);
	 * vo.setPassword(password);
	 * 
	 * UserDAO userDAO = new UserDAO(); UserVO user = userDAO.getUser(vo);
	 * 
	 * // 3. ȭ�� �׺���̼� =>login�ܰ迡�� model�� ���� ��ü�� ����. ModelAndView mav = new
	 * ModelAndView(); if (user != null) { // return "getBoardList.do"; //
	 * mav.setViewName("getBoardList.do");
	 * 
	 * // presentation-layer�� ViewResolver�� ����ϱ� ���� ����
	 * mav.setViewName("redirect:getBoardList.do");
	 * 
	 * } else { // return "login";
	 * 
	 * // mav.setViewName("login.jsp");
	 * 
	 * // presentation-layer�� ViewResolver�� ����ϱ� ���� ����
	 * mav.setViewName("redirect:login.jsp"); } return mav; }
	 */

}
