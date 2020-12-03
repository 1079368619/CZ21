package com.yc.damai.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		
		// 获取请求中的验证码
		String rvcode = request.getParameter("vcode");
		// 获取会话中的验证码
		String svcode = (String) request.getSession().getAttribute("vcode");
		// 对比验证码
		if (svcode.equalsIgnoreCase(rvcode) == false) {
			append(response, Result.failure("验证码错误！"));
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
		// 获取请求中的验证码
		String rvcode = request.getParameter("vcode");
		// 获取会话中的验证码
		String svcode = (String) request.getSession().getAttribute("vcode");
		// 获取会话中的验证码时间值
		Date svtime = (Date) request.getSession().getAttribute("vtime");

		// 计算时间差 （毫秒）
		long time = System.currentTimeMillis() - svtime.getTime();
		// 判断是否超时
		if (time / 1000 > 60) {
			append(response, Result.failure("验证码超时！"));
			return;
		}
		
		// 对比验证码
		if (svcode.equalsIgnoreCase(rvcode) == false) {
			append(response, Result.failure("验证码错误！"));
			return;
		}

		user.setUsername(username);
		user.setPassword(password);
		
		try {
			List<User> dbuser = biz.login(user);
			//登录后，将用户对象保存到会话中
			request.getSession().setAttribute("loginedUser", dbuser.get(0));
			
			//将账户保存在Cookie中
			Cookie cookie = new Cookie("loginedUser", username);
			cookie.setMaxAge(60 * 1);
			response.addCookie(cookie);
			
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
	
	public void queryName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object loginedUser = request.getSession().getAttribute("loginedUser");
		if(loginedUser == null || loginedUser.equals("")) {
			append(response, Result.failure("请登录"));
			return;
		}
		System.out.println(loginedUser.toString());
		User user = (User) loginedUser;
		try {
			String name = dao.queryName(user.getName().toString()) + "";
			System.out.println(name);
			append(response, name);
		} catch (SQLException e) {
			e.printStackTrace();
			append(response, Result.failure("请联系管理员"));
		}
		
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 *  会话失效：
		 *  	1. 自动失效 30分钟， 30分钟之内不与服务交互（点击链接）
		 *  	2. 手动失效
		 */
		request.getSession().invalidate();
		// 跳转到登录页面： 响应重定向
		response.sendRedirect("login.html");
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void userCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// UserCountListener ucl = new UserCountListener();
		// Servlet， Filter， Listener 服务器组件， 由服务器创建
		// 获取应用上下文对象中 在线总人数
		Integer count = (Integer) getServletContext().getAttribute("count");
		response.getWriter().append("" + (count == null ? 0 : count));
	}
}
