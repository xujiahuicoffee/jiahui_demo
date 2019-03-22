package com.coffee.jiahui.config.web.my;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Holder;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class MySelfAop {

	@Pointcut("@annotation(com.coffee.jiahui.config.web.my.MySelf)")
	public void MySelf(){		
	}
	
	@Before(value = "MySelf()")
	public void MySelfCheck(JoinPoint point){
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();
		MySelf my = method.getAnnotation(MySelf.class);
		
		String name = my.name();
		String homeTown = my.homeTown();
		int age = my.age();
		 
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("name", name);
		request.setAttribute("homeTown", homeTown);
		request.setAttribute("age", age);
	}
}
