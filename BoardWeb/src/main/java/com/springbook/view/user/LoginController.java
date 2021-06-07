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

		// 3. 화면 네비게이션 =>login단계에선 model에 담을 객체는 없다.
		ModelAndView mav = new ModelAndView();
		if (user != null) {
//			return "getBoardList.do";
//			mav.setViewName("getBoardList.do");
			
//			presentation-layer의 ViewResolver를 사용하기 위한 변경
			mav.setViewName("redirect:getBoardList.do");
			
		} else {
//			return "login";

//			mav.setViewName("login.jsp");

//			presentation-layer의 ViewResolver를 사용하기 위한 변경
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}

}
