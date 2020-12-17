package com.yc.CZ21S2Plyspringboot.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.CZ21S2Plyspringboot.dao.Account;
import com.yc.CZ21S2Plyspringboot.dao.AccountDao;

@RestController
public class IndexAction {

	@RequestMapping("hello.action")
	public String hello() {
		return "hello world";
	}
	
	@Resource
	private AccountDao adao;
	
	@RequestMapping("alist.action")
	public List<Account> query() {
		return adao.selectAll();
	}
}
