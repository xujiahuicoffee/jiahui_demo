package com.coffee.jiahui.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionTestController {

	@RequestMapping(value = "/exceptionTest", method = RequestMethod.GET)
	public String exceptionTest(String name) throws IOException {
		if ("aaa".equals(name)) {
			throw new RuntimeException("什么情况？");
		}else if ("bbb".equals(name)) {
			throw new IOException();
		}else {
			return "hello world";
		}
	}
	
}
