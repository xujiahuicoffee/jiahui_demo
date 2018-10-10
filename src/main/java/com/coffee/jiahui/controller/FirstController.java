package com.coffee.jiahui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.jiahui.domain.CoinMessage;
import com.coffee.jiahui.service.CoinMessageService;

@RestController
public class FirstController {

	@Autowired
	private CoinMessageService coinMessageService;
	
	@RequestMapping(value = "/getCount", method = RequestMethod.GET)
	public String getCoinMessageCount(){
		List<CoinMessage> list = coinMessageService.listAllCoinMessage();
		return "总共有 "+list.size()+" 条数据";
		
	}
}
