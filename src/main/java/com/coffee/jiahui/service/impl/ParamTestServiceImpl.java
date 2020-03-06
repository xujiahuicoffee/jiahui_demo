package com.coffee.jiahui.service.impl;

import org.springframework.stereotype.Service;

import com.coffee.jiahui.service.ParamTestService;
import com.coffee.jiahui.vo.StudentParam;

@Service
public class ParamTestServiceImpl implements ParamTestService {

	@Override
	public boolean paramTest(StudentParam param) {
	
		System.out.println(param);
		
		return false;
	}
	
	public static void test(StudentParam param) {
		param.setName("aaa");
		System.out.println(param);
	}
	
	public static void main(String[] args) {
		
		StudentParam sp = new StudentParam();
		System.out.println(sp);
		sp.setName("qwer");
		test(sp);
		
		System.out.println(sp.getName());
		
		
//		String str = new String("hello");
//		System.out.println(System.identityHashCode(str));
//		testString(str);
		
	}
	
	public static void testString(String str) {
		System.out.println(System.identityHashCode(str));
	}

}
