package com.yc.spring.aop.proxy;

public class RealSubject implements Subject {

	//真实主题：原告，房东
	@Override
	public void say() {
		System.out.println("这是一套好房子");
	}

}
