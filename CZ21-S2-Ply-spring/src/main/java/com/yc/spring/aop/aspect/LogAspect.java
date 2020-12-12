package com.yc.spring.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Before("execution(* com.yc.spring.aop.aspect.UserBiz.*(..))")
	public void before() {
		System.out.println("前置====");
	}
	
	@After("execution(* com.yc.spring.aop.aspect.UserBiz.reg*(..))")
	public void after() {
		System.out.println("====后置");
	}
	
	
	@AfterThrowing(
			value="execution(* com.yc.spring.aop.aspect.*.*(..))",
			throwing = "e"
	)
	public void exception(JoinPoint jp, Exception e) {
		System.out.println("======== 方法签名：" + jp.getSignature());
		System.out.println("======== 参数列表：" + Arrays.toString(jp.getArgs()));
		System.out.println("======== 异常消息：" + e.getMessage());
	}
	
	
	@AfterReturning(
			value="pc()",
			returning = "ret"
	)
	public void returning(Object ret) {
		System.out.println("==返回结果是：" + ret);
	}
	
	
	@Around("pc()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		long time = System.currentTimeMillis();
		
		try {
			System.out.println("****环绕增强：前置");
			Object ret = pjp.proceed();
			System.out.println("****环绕增强：返回");
			return ret;
		} catch (Throwable e) {
			System.out.println("**环绕增强：异常**");
			throw e;
		} finally {
			System.out.printf("环绕增强：后置     一共耗时%d毫秒****\n" ,System.currentTimeMillis() - time);
		}
		
	}
	
	@Pointcut("execution(* com..aspect.*.*(..))")
	public void pc() {}
	
	
}
