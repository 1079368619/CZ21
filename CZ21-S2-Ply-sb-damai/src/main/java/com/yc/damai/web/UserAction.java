package com.yc.damai.web;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.biz.BizException;
import com.yc.damai.biz.UserBiz;
import com.yc.damai.dao.UserDao;
import com.yc.damai.po.Result;
import com.yc.damai.po.User;

@RestController
public class UserAction {

	@Resource
	private UserDao udao;
	
	@Resource
	private UserBiz ubiz;
	
	@RequestMapping(path="user.s",params="op=getLoginedUser")
	public User getLoginedUser(String username,HttpSession session) {
		User user = (User) session.getAttribute("loginedUser");
		return user;
	}
	
	@RequestMapping("login.s")
	public Result login(String username, String password, String vcode, HttpSession session) {
		try {
			User loginedUser = (User) ubiz.login(username, password, vcode, session);
			session.setAttribute("loginedUser", loginedUser);
			return Result.success("登录成功");
		} catch (BizException | SQLException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage());
		}
	}
	
	
	@RequestMapping("reg")
	public Result reg(User user, String repassword, String vcode, HttpSession session) {
		try {
			if(user.getPassword() == repassword) {
				throw new BizException("两次密码不一致！");
			}
			String svcode = (String) session.getAttribute("vcode");
			if( !vcode.equalsIgnoreCase(svcode)) {
				throw new BizException("验证码错误");
			}
			ubiz.register(user);
			return Result.success("注册成功");
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage());
		}
	}
	
}
