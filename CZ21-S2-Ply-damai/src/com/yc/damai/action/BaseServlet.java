package com.yc.damai.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import org.eclipse.jdt.internal.compiler.ast.ThisReference;

public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String op = request.getParameter("op");
		if(op == null) {
			throw new ServletException("必须提供op字段！！！");
		}
		//
		try {
			//
			Method m = getClass().getDeclaredMethod(op, HttpServletRequest.class, HttpServletResponse.class);
			//
			m.setAccessible(true);
			//
			m.invoke(this, request, response);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new ServletException("获取" + op + "方法", e);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ServletException("调用" + op + "方法", e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
