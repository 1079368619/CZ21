package com.yc.damai.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.damai.biz.BizException;
import com.yc.damai.biz.UserBiz;
import com.yc.damai.dao.UserDao;
import com.yc.damai.po.Result;
import com.yc.damai.po.User;

@WebServlet("/user.s")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	private UserBiz biz = new UserBiz();
	private UserDao dao = new UserDao();
	
	public void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		//密码验证
		if(password == repassword) {
			response.getWriter().append("两次密码不一致！");
			return;
		}
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
		user.setName(request.getParameter("name"));
		user.setSex(request.getParameter("sex"));
		user.setAddr(request.getParameter("addr"));
		
		try {
			biz.register(user);
			response.getWriter().append("注册成功");
		} catch (BizException e) {
			e.printStackTrace();
			response.getWriter().append(e.getMessage());
		}
	}


	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		user.setUsername(username);
		user.setPassword(password);
		
		try {
			Object dbuser = biz.login(user);
			//登录后，精用户对象保存到会话中
			request.getSession().setAttribute("loginedUser", dbuser);
			append(response, Result.success("登录成功"));
		} catch (BizException e) {
			//该异常为业务异常，业务异常必须捕获+处理
			e.printStackTrace();
			append(response, Result.failure(e.getMessage()));
		} catch (IOException | SQLException e) {
			//IOException该异常为系统异常，可以不捕获，是程序的bug
			e.printStackTrace();
			append(response, Result.failure("登录失败，请联系管理员"));
		}
	}
	
	/**
	 * 获取当前登录的用户对象
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getLoginedUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object loginedUser = request.getSession().getAttribute("loginedUser");
		append(response, loginedUser);
	}
}
