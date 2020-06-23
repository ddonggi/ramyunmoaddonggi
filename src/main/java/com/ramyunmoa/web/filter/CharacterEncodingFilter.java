package com.ramyunmoa.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//사전 액션
		request.setCharacterEncoding("UTF-8");
		System.out.println("인코딩 필터");
		
		//다음 서블릿, 또는 다음 필터가 실행되도록...
		chain.doFilter(request, response);
		
		//사후 액션
	}
}
