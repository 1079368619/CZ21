package com.yc.javaee.d1203.test;

public class DemoTest {

	@MyBefore
	public void before() {
		System.out.println("ÿ�������Եķ���ִ��ǰ��ִ�еķ���");
	}
	
	@MyAfter
	public void after() {
		System.out.println("ÿ�������Եķ���ִ�к�ִ�еķ���");
	}
	
	@MyTest
	public void test1() {
		System.out.println("����test1");
	}
	
	public void test2() {
		System.out.println("����test1");
	}
	
	@MyTest
	public void test3() {
		System.out.println("����test1");
	}
	
}
