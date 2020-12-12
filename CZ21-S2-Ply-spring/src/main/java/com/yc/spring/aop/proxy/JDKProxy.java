package com.yc.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {

	public static <T> T proxy(final T subject) {
		ClassLoader loader = subject.getClass().getClassLoader();
		Class<?>[] interfaces = subject.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("交通方便！");
				Object ret = method.invoke(subject, args);
				System.out.println("生活方便！");
				return ret;
			}
			
		};
		
		//
		@SuppressWarnings("unchecked")
		T ret = (T) Proxy.newProxyInstance(loader, interfaces, h);
		return ret ;
	}
	
	
	public static void main(String[] args) {
		Subject realSubject = new RealSubject();
		Subject proxySubject = JDKProxy.proxy(realSubject);
		proxySubject.say();
		
		Subject realSubject1 = new RealSubject1();
		Subject proxySubject1 = JDKProxy.proxy(realSubject1);
		proxySubject1.say();
	}

}
