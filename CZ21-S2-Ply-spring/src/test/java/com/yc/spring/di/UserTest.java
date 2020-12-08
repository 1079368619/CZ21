package com.yc.spring.di;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

	private static ClassPathXmlApplicationContext cxt;
	
	@BeforeClass
	public static void before() {
		cxt = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@AfterClass
	public static void after() {
		cxt.close();
	}
	
	@Test
	public void test1() {
		User u = cxt.getBean(User.class);
		Assert.assertEquals("林冲", u.getName());
		Assert.assertEquals(40, u.getAge());
	}
	
	@Test
	public void test2() {
		User u = (User) cxt.getBean("user1");
		Assert.assertEquals("李逵", u.getName());
		Assert.assertEquals(35, u.getAge());
		Assert.assertEquals("lk@126.com", u.getEmail());
	}
	
	@Test
	public void test3() {
		User u = (User) cxt.getBean("user");
		Assert.assertEquals("篮球", u.getLikes()[0]);
		Assert.assertEquals("电影", u.getLikes()[1]);
		Assert.assertEquals("手游", u.getLikes()[2]);
	}
	
	@Test
	public void test4() {
		User u = (User) cxt.getBean("user2");
		Assert.assertEquals("宋江", u.getName());
		Assert.assertEquals("吴用", u.getFriend().getName());
		Assert.assertEquals(45, u.getFriend().getAge());
	}
}
