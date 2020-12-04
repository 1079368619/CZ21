package com.yc.javaee.d1203.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

	public static void main(String[] args) {
		test(new DemoTest());
	}

	public static void test(Object obj) {
		Class<?> cls = obj.getClass();
		
		Method[] methods = cls.getMethods();
		Method methodBefore = null;
		Method methodAfter = null;
		List<Method> methodTest = new ArrayList<>();
		int j = 0;
		for(Method m : methods) {
			Annotation[] a = m.getAnnotations();
			//
			for(int i=0;i<a.length;i++) {
				if(a[0].annotationType().getName().equals("MyBefore")) {
					methodBefore = m;
				} else if(a[0].annotationType().getName().equals("MyAfter")) {
					methodAfter = m;
				} else if(a[0].annotationType().getName().equals("MyTest")) {
					methodTest.add(m);
				}
			}
		}
		if(methodTest != null) {
			for(Method m : methodTest) {
				if(m != null) {
					try {
						//
						if(methodBefore != null) {
							methodBefore.invoke(obj);
						}
						m.invoke(obj);
						//
						if(methodAfter != null) {
							methodAfter.invoke(obj);
						}
					} catch (IllegalAccessException | IllegalArgumentException  e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
						System.out.println("该方法内部错误！");
					}
				}
			}
		}
		
	}

}
