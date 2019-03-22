package com.coffee.jiahui.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.coffee.jiahui.config.web.my.MySelf;
import com.coffee.jiahui.domain.CoinMessage;
import com.coffee.jiahui.service.CoinMessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

//import net.sf.ehcache.Cache;
//import net.sf.ehcache.CacheManager;
//import net.sf.ehcache.Element;

@RestController
public class FirstController {

	@Autowired
	private CoinMessageService coinMessageService;
	
//	@Autowired
//	@Qualifier("oneCacheManager")
//	private CacheManager cacheManager;
	
	/**
	 * 配置数据库连接池 的测试controller
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/getCount", method = RequestMethod.GET)
	public String getCoinMessageCount(String name){
		List<CoinMessage> list = coinMessageService.listAllCoinMessage(name);
		return "总共有 "+list.size()+" 条数据";
		
	}
	
	/**
	 * 配置tkmybatis实现分页、配置ehcache缓存的测试controller
	 * @param pn
	 * @param ps
	 * @param name
	 * @return
	 */
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
	
	/**
	 * 缓存相关
	 * @param cacheKey
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping(value = "/getCacheElement", method = RequestMethod.GET)
//	public String getCacheElement(String cacheKey) throws Exception {
//		
//		JSONObject returnJson = new JSONObject();		
//		Cache cache = cacheManager.getCache("GoodsType");
//		Element e = cache.get(cacheKey);
//		if (e == null) {
//			returnJson.put("message", "没有缓存");
//			return returnJson.toString();
//		}
//		Object obj = e.getObjectValue();
//		return obj.toString();
//	}
	
	/**
	 * AOP ceshi
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/whoIAm",method = RequestMethod.GET)
	@MySelf(name = "xujiahiu", homeTown = "QianDaoHu", age = 24)
	public JSONObject whoIAm(HttpServletRequest request){
		JSONObject json = new JSONObject();
		json.put("name", request.getAttribute("name"));
		json.put("homeTown", request.getAttribute("homeTown"));
		json.put("age", request.getAttribute("age"));
		return json;		
	}
	
	
	/**
	 * 过滤器测试
	 * @return
	 */
	@RequestMapping(value = "/testFilter",method = RequestMethod.GET)
	public String testFilter(){	
		return "hello world!";		
	}
	
	
}
