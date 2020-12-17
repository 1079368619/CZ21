package com.yc.damai.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.po.Result;

@RestController
public class LogoutAction {

	@RequestMapping("out.s")
	public Result logout(HttpSession session) {
		Object loginedUser = session.getAttribute("loginedUser");
		if(loginedUser == null) {
			return Result.failure("你还未登录");
		}
		session.removeAttribute("loginedUser");
		return Result.success("成功退出");
	}
}
