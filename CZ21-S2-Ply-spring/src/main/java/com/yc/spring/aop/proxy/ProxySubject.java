package com.yc.spring.aop.proxy;

public class ProxySubject implements Subject {

	private Subject subject = new RealSubject();
	
	//代理主题：中介，律师。。。
	@Override
	public void say() {
		//增强的功能
		System.out.println("交通方便！");
		subject.say();
		//增强的功能
		System.out.println("生活方便！");
		
	}

}
