package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
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

		// 3. ȭ�� �׺���̼� =>login�ܰ迡�� model�� ���� ��ü�� ����.
		ModelAndView mav = new ModelAndView();
		if (user != null) {
//			return "getBoardList.do";
//			mav.setViewName("getBoardList.do");
			
//			presentation-layer�� ViewResolver�� ����ϱ� ���� ����
			mav.setViewName("redirect:getBoardList.do");
			
		} else {
//			return "login";

//			mav.setViewName("login.jsp");

//			presentation-layer�� ViewResolver�� ����ϱ� ���� ����
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}

}
