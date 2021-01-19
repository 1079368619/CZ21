package com.yc.mvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;
import com.yc.mvc.po.Result;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("handler:" + handler);
		if(request.getSession().getAttribute("loginedUser") == null ) {
			if(request.getHeader("Accept").contains("application/json")) {
				Result res = Result.failure("请先登录系统", null);
				String json = new Gson().toJson(res);
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().append(json);
			}else {
				response.sendRedirect("login.html");
			}
			return false;
		} else {
			return true;
		}
	}

}
