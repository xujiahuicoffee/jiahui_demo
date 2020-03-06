package com.coffee.jiahui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.jiahui.service.StudentMessageService;

/**
 * 	关于事务传播行为的测试
 * @author xujiahui  
 * @date 2019年4月14日  下午5:58:04
 */
@RestController
@RequestMapping("/trans")
public class TransactionalTestController {

	@Autowired
	private StudentMessageService studentMessageService;

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1(String name) {
		studentMessageService.insertStudentMessage1(name);
		return "success";
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2(String name) {
		studentMessageService.insertStudentMessage2(name);
		return "success";
	}
}
