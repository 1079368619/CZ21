package com.yc.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

	@Test
	public void test1() {
		ClassPathXmlApplicationContext cxt;
		cxt = new ClassPathXmlApplicationContext("beans.xml");
		Hello h = (Hello) cxt.getBean("hello");
		h.sayHello();
		cxt.close();
	}
}
