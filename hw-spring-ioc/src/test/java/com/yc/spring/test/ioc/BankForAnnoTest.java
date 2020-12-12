package com.yc.spring.test.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yc.spring.bank.BankConfig;
import com.yc.spring.bank.biz.AccountBiz;
import com.yc.spring.bank.dao.AccountDao;
import com.yc.spring.bank.web.AccountAction;

public class BankForAnnoTest {

	AnnotationConfigApplicationContext cxt = 
			new AnnotationConfigApplicationContext(BankConfig.class);
	
	@Test
	public void test1() {
		AccountBiz a = cxt.getBean(AccountBiz.class);
		AccountDao b = cxt.getBean(AccountDao.class);
		AccountAction c = cxt.getBean(AccountAction.class);
		Assert.assertNotNull(a);
		Assert.assertNotNull(b);
		Assert.assertNotNull(c);
		
		Assert.assertNotNull(a.getAdao());
		Assert.assertNotNull(c.getAbiz());
	}
}
