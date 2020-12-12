package com.yc.spring.aop.aspect;

import org.springframework.stereotype.Service;

@Service
public class UserBiz implements IUserBiz {

	public boolean login(String name, String pwd) {
		System.out.println("登录");
		return true;
	}
	
	public boolean register(String name, String pwd, String phone) {
		System.out.println("注册");
		int i = 1/0;
		return false;
	}
}
