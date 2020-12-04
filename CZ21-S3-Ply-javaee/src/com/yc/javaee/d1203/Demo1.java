package com.yc.javaee.d1203;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.junit.Test;

public class Demo1 {

	@Test
	public void test1() {
		System.out.println("=======String=======");
		action("abc");
		
		System.out.println("=======Date=======");
		action(new Date());
		
		A a = new A();
		B b = new B();
		
		System.out.println("=======A=======");
		action(a);
		
		System.out.println("=======B=======");
		action(b);
	}

	public static void action(Object obj) {
		Class<?> cls = obj.getClass();//
		
		Field[] fileds = cls.getDeclaredFields();
		
		System.out.println("======= 带 Declared =======");
		for(Field f : fileds) {
			System.out.println(f.getName() + "\t" + f.getType());
		}
		
		System.out.println("======= 不带 Declared =======");
		
		fileds = cls.getFields();
		for(Field f : fileds) {
			System.out.println(f.getName() + "\t" + f.getType());
		}
		
		try {
			Method method = cls.getDeclaredMethod("substring", int.class, int.class);
			Object result = method.invoke(obj, 1, 2);
			System.out.println("*****substring:" + result);
			
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			System.out.println("获取方法错误:" + cls);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			System.out.println("执行方法错误:" + cls);
		}
		
		
	}
}



class A{
	protected int a;
	public int b;
}

class B extends A{
	protected int c;
	public int d;
}