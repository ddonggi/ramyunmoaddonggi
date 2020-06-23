package com.ramyunmoa.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;

public class NewlectureAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		//인증이 성공 후 할 업무를 적는 곳
		System.out.println("로그인 성공후에 뭐할꼬?");
		HttpSession session = request.getSession();
		
		//원하는곳으로 보내는 루틴
		SavedRequest savedRequest = (SavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
		if(savedRequest != null) {
			String returnURL = savedRequest.getRedirectUrl();
			response.sendRedirect(returnURL);
		} else {
			response.sendRedirect("/index");
			
		}
	}

}
