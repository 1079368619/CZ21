package com.yc.spring.aop.aspect;

public interface IUserBiz {

	public boolean login(String name, String pwd);
	
	public boolean register(String name, String pwd, String phone) ;

}
