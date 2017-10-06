package com.flowershop.login.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.flowershop.login.domain.UserVo;
import com.flowershop.login.service.impl.LoginServiceImpl;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private LoginServiceImpl loginService;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("authUser") == null) {
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if (loginCookie != null) {
				UserVo userVo = loginService.checkLoginBefore(loginCookie.getValue());
				if (userVo != null) {
					session.setAttribute("authUser", userVo);
					return true;
				}
			}
			response.sendRedirect("/login");
			return false;
		}
		return true;
	}

}