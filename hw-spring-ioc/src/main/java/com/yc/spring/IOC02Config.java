package com.yc.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.yc.spring.bank.bean.Account;
import com.yc.spring.bbs.bean.Page;
import com.yc.spring.bbs.bean.User;

public class IOC02Config {

	@Bean
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
	
	
}
