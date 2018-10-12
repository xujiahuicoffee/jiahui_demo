package com.coffee.jiahui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.coffee.jiahui.domain.CoinMessage;
import com.coffee.jiahui.service.CoinMessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@RestController
public class FirstController {

	@Autowired
	private CoinMessageService coinMessageService;
	
	@Autowired
	@Qualifier("oneCacheManager")
	private CacheManager cacheManager;
	
	@RequestMapping(value = "/getCount", method = RequestMethod.GET)
	public String getCoinMessageCount(String name){
		List<CoinMessage> list = coinMessageService.listAllCoinMessage(name);
		return "总共有 "+list.size()+" 条数据";
		
	}
	
	@RequestMapping(value = "/getCoinMessage", method = RequestMethod.GET)
	public JSONObject getCoinMessage(int pn, int ps, String name){
		PageHelper.startPage(pn, ps);
		List<CoinMessage> list = coinMessageService.listAllCoinMessage(name);
		PageInfo<CoinMessage> pageInfo = new PageInfo<>(list);
		
		JSONObject pageJson = new JSONObject();
		pageJson.put("total", pageInfo.getTotal());
		pageJson.put("currentPage", pageInfo.getPageNum());
		pageJson.put("pages", pageInfo.getPages());
		JSONObject json = new JSONObject();
		json.put("data", pageInfo.getList());
		json.put("page", pageJson);
		
		return json;
	}
	
	@RequestMapping(value = "/getCacheElement", method = RequestMethod.GET)
	public String getCacheElement(String cacheKey) throws Exception {
		
		JSONObject returnJson = new JSONObject();		
		Cache cache = cacheManager.getCache("GoodsType");
		Element e = cache.get(cacheKey);
		if (e == null) {
			returnJson.put("message", "没有缓存");
			return returnJson.toString();
		}
		Object obj = e.getObjectValue();
		return obj.toString();
	}
}
