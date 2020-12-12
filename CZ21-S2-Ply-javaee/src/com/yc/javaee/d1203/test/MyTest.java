package com.yc.javaee.d1203.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})

@Retention(RetentionPolicy.RUNTIME)

@Inherited
public @interface MyTest {

	String name() default "123";
	
	
	String[] type() default "123";
	
	
	String value() default "321";

}
