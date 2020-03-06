package com.coffee.jiahui.config.web.my;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class orderAop {

	@Pointcut("execution(* com.coffee.jiahui.controller..*.*(..))")
	public void test() {}
	
	@Before(value = "test()")
	public void doSomeThing1(JoinPoint point) {
		System.out.println("before1");
	}
	
	@Before(value = "test()")
	public void doSomeThing2(JoinPoint point) {
		System.out.println("before2");
	}
}
