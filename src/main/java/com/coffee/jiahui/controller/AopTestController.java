package com.coffee.jiahui.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopTestController {

	@RequestMapping(value = "/aopTest", method = RequestMethod.GET)
	public String aopTest() {
		return null;	
	}
}
