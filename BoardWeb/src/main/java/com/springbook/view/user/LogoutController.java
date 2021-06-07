package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

public class LogoutController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("�α׾ƿ� ó��");
		
		// 1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
		HttpSession session = request.getSession();
		session.invalidate();

		// 2. ���� ���� ��, ����ȭ������ ���ư���.
		ModelAndView mav = new ModelAndView();
		//mav.setViewName("login.jsp");

		//ViewResolver����� ���� ����
		mav.setViewName("redirect:login.jsp");
		return mav;
		
		//return "login";
	}

}