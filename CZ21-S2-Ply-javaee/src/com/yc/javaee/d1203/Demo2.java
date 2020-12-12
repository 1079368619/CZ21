package com.yc.javaee.d1203;

import java.lang.reflect.Field;
import java.util.Arrays;

import javax.servlet.annotation.WebServlet;

@WebServlet("/web.s")

@Test("test")
public class Demo2 {

	@Test(name = "test", type = {"type", "type2", "type3"})
	private int age;
	
	@org.junit.Test
	public void test1() throws NoSuchFieldException, SecurityException {
		
		Test t = Demo2.class.getAnnotation(Test.class);
		
		System.out.println(t.name());
		System.out.println(Arrays.toString(t.type()));
		System.out.println(t.value());
		
		t = SubDemo2.class.getAnnotation(Test.class);
		
		System.out.println(t.name());
		System.out.println(Arrays.toString(t.type()));
		System.out.println(t.value());
		
		Field ageField = SubDemo2.class.getField("age");
		t = ageField.getAnnotation(Test.class);
		
		System.out.println(t.name());
		System.out.println(Arrays.toString(t.type()));
		System.out.println(t.value());
		
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}



class SubDemo2 extends Demo2 {
	
}
