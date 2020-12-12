package com.yc.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.yc.spring.bank.bean.Account;
import com.yc.spring.bbs.bean.Page;
import com.yc.spring.bbs.bean.User;

public class IOC03Config {

	@Bean
	@Primary
	public Account account() {
		Account a = new Account();
		return a;
	}
	
	@Bean
	@Scope("prototype")
	public Account account1() {
		Account a = new Account();
		return a;
	}
	
	@Bean
	public Account account2() {
		Account a = new Account();
		return a.getInstance();
	}
	
	@Bean
	public Account account3() {
		Account a = new Account();
		return a.getInstance();
	}
	
	@Bean
	@Scope("prototype")
	public Account account4() {
		Account a = new Account();
		return a.getInstance1();
	}
	
	@Bean(name="myUser")
	public User myUser() {
		User u = new User();
		u.setUname("武松");
		u.setUpass("abc123");
		u.setHead("20.gif");
		u.setGender(1);
		return u;
	}
}
