package com.yc.spring.bank.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.spring.bank.dao.AccountDao;

//业务层
@Service
public class AccountBiz {

	//自动装载其他组件
	@Autowired
	private AccountDao adao;
	
	public AccountDao getAdao() {
		return adao;
	}
}
