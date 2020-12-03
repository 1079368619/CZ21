package com.yc.damai.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// final 禁止子类重写该方法
	protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 在此设置字符集编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String op = request.getParameter("op");
		if(op == null) {
			throw new ServletException("必须提供op字段！！！");
		}
		// 通过反射获取 public 方法对象
		// getClass().getMethod(name, parameterTypes)
		try {
			//通过反射获取 定义的（当前类中定义的） 方法对象
			Method m = getClass().getDeclaredMethod(op, HttpServletRequest.class, HttpServletResponse.class);
			//设置强制访问 （非public）
			m.setAccessible(true);
			//调用method对象， 执行方法
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

	public void append(HttpServletResponse response, Object obj) throws ServletException, IOException {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		response.getWriter().append(json);
	}
}
