package com.coffee.jiahui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.jiahui.domain.CoinMessage;
import com.coffee.jiahui.mapper.CoinMessageMapper;
import com.coffee.jiahui.service.CoinMessageService;

//import tk.mybatis.spring.annotation.MapperScan;

@Service
public class CoinMessageServiceImpl implements CoinMessageService{

	@Autowired
	private CoinMessageMapper coinMessageMapper;
	
	@Override
	public List<CoinMessage> listAllCoinMessage() {
		List<CoinMessage> list = coinMessageMapper.selectAll();
		return list;
	}

}
