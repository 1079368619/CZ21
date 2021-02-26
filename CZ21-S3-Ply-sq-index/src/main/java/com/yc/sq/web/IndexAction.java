package com.yc.sq.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.sq.bean.Result;
import com.yc.sq.bean.SqMember;
import com.yc.sq.web.remote.IUserAction;

@RestController
public class IndexAction {

	@Resource
	private IUserAction iua;
	
	@RequestMapping("login")
	public Result login(SqMember sm, HttpSession session) {
		Result ret = iua.login(sm);
		if(ret.getCode() == 1) {
			System.out.println(session.getId());
			session.setAttribute("loginedUser", ret.getData());
		}
		return ret;
	}
	
	@RequestMapping("getLoginedUser")
	public Result getLoginedUser(HttpSession session) {
		System.out.println(session.getId());
		return Result.success("会话中的用户对象：", session.getAttribute("loginedUser"));
	}
}
