package com.yc.vue.d1128.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.vue.d1128.bean.User;
import com.yc.vue.d1128.biz.UserBiz;
import com.yc.vue.d1128.dao.UserDao;
import com.yc.vue.dyg.biz.BizException;
import com.yc.vue.dyg.web.BaseServlet;

@WebServlet("/user.s")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	private UserBiz biz = new UserBiz();
	
	protected void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setHead(request.getParameter("head"));
		user.setName(request.getParameter("name"));
		user.setPwd(request.getParameter("pwd"));
		try {
			biz.register(user);
			response.getWriter().append("注册成功！！！");
		} catch (BizException e) {
			e.printStackTrace();
			response.getWriter().append(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
