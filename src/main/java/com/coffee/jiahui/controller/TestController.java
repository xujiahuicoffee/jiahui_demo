package com.coffee.jiahui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.jiahui.domain.CoinMessage;
import com.coffee.jiahui.service.ZGisService;

@RestController
public class TestController {
	
	@Autowired
	private ZGisService zGisService;

	@RequestMapping(value = "/xxx", method = RequestMethod.GET)
	public String xxx() throws Exception{
//		peopleService.insertData();
		long t1 = System.currentTimeMillis();
		zGisService.insertData();
		long t2 = System.currentTimeMillis();
		return "over! 耗时"+(t2-t1)/1000+"秒";
	}
}
