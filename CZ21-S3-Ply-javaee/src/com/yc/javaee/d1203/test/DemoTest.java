package com.yc.javaee.d1203.test;

public class DemoTest {

	@MyBefore
	public void before() {
		System.out.println("每个被测试的方法执行前，执行的方法");
	}
	
	@MyAfter
	public void after() {
		System.out.println("每个被测试的方法执行后，执行的方法");
	}
	
	@MyTest
	public void test1() {
		System.out.println("这是test1");
	}
	
	public void test2() {
		System.out.println("这是test1");
	}
	
	@MyTest
	public void test3() {
		System.out.println("这是test1");
	}
	
}
