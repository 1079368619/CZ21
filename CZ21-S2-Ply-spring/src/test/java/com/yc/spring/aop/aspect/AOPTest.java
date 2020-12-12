package com.yc.spring.aop.aspect;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AOPConfig.class)
public class AOPTest {

	@Resource 
	private IUserBiz ubiz;
	
	@Test
	public void test1(){
		ubiz.login("zhangsan", "123");
		
		ubiz.register("zhangsan", "123", "33@qq.com");
	}
}
