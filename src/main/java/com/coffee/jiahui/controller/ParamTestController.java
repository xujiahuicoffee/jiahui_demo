package com.coffee.jiahui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.jiahui.service.ParamTestService;
import com.coffee.jiahui.vo.StudentParam;

@RestController
public class ParamTestController {
	
	@Autowired
	private ParamTestService paramTestService;

	@RequestMapping(value = "/paramTest", method = RequestMethod.POST)
	public String paramTest(@RequestBody StudentParam param) {
		
		System.out.println(param);
		
		paramTestService.paramTest(param);	
		return null;
		
	}
	
}
