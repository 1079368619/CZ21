package com.yc.CZ21S2Plyspringboot.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.CZ21S2Plyspringboot.biz.BankBiz;
import com.yc.CZ21S2Plyspringboot.dao.Account;

@RestController
public class UserAction {

	@Resource
	private BankBiz bbiz;
	
	@RequestMapping("sendVcode")
	public String sendVocde(String name, HttpSession session) {
		String vcode = bbiz.sendVcode(name);
		//
		session.setAttribute("vcode", vcode);
		//
		return "";
	}
	
	@RequestMapping("resetPwd")
	public String resetPwd(String name, String vcode, String pwd, HttpSession session) {
		return bbiz.resetPwd(name,vcode, pwd, (String)session.getAttribute("vcode"));
	}
}
