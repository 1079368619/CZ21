package com.yc.spring.bank.biz;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.spring.bank.bean.Account;
import com.yc.spring.bank.bean.Record;
import com.yc.spring.bank.dao.AccountDao;
import com.yc.spring.bank.dao.RecordDao;

@Service
public class BankBiz {

	@Resource
	private AccountDao adao;
	
	@Resource
	private RecordDao rdao;
	
	//存款
	@Transactional(
			rollbackFor = IOException.class
	)
	public void deposit(int accountid, double money) throws IOException {
		Account a = new Account();
		a.setAccountid(accountid);
		a.setBalance(money);
		adao.update(a);
		
//		boolean b = true;
//		if (b) {
//			throw new IOException("编译期异常");
//		}
		
		Record r = new Record();
		r.setAccountId(accountid);
		r.setOpmoney(money);
		rdao.insert(r);
	}
	
	// 转账
	@Transactional(
			rollbackFor = IOException.class
	)
	public void transfer(int aid, int bid, double money) throws IOException {
//		// 判断账户a的金额是否有money
//		Account a = adao.selectById(aid);
//		if (a.getBalance() < money) {
//			throw new RuntimeException("你的余额不足");
//		}
//		// 扣除a账户money元
//		a.setAccountid(aid);
//		a.setBalance(money);
//		adao.transfer(a);
//		addRecord(aid, money);
//
//		// b账户增加money元
//		Account b = new Account();
//		b.setAccountid(bid);
//		b.setBalance(money);
//		adao.update(b);
//		addRecord(bid, money);
		
		deposit(aid, money);
		deposit(bid, -money);
	}

	// 添加流水账记录
	public void addRecord(int accountid, double money) {
		Record r = new Record();
		r.setAccountId(accountid);
		r.setOpmoney(money);
		rdao.insert(r);
	}
	
}
