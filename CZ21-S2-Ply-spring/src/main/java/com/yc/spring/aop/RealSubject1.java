package com.yc.spring.aop;

public class RealSubject1 implements Subject {

	//真实主题：原告，房东
	@Override
	public void say() {
		System.out.println("我的房子很好！");
	}

}
