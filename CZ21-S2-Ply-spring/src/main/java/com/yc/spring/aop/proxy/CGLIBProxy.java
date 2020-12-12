package com.yc.spring.aop.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CGLIBProxy {

	@SuppressWarnings("unchecked")
	public static <T> T proxy(final T subject) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(subject.getClass());
		//
		enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				System.out.println("CGLIB交通方便！");
				Object ret = methodProxy.invoke(subject, args);
				System.out.println("CGLIB生活方便！");
				return ret;
			}
			
		});
		return (T) enhancer.create() ;
	}
	
	
	public static void main(String[] args) {
		Subject realSubject = new RealSubject();
		Subject proxySubject = proxy(realSubject);
		proxySubject.say();
		
		Subject realSubject1 = new RealSubject1();
		Subject proxySubject1 = proxy(realSubject1);
		proxySubject1.say();
	}

}
