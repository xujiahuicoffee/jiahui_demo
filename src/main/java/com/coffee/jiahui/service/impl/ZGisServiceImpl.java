package com.coffee.jiahui.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.jiahui.mapper.ZGisMapper;
import com.coffee.jiahui.service.ZGisService;

@Service
public class ZGisServiceImpl implements ZGisService {

	@Autowired
	private ZGisMapper zGisMapper;

	@Override
	public void insertData() throws Exception {
		
//		for (int i = 0; i < 100000; i++) {
////			People p = new People();
////			p.setName("jn");
//			double jd = Math.random()+120;
//			double wd = Math.random()+30;
//			String location = "point("+jd+" "+wd+")";
////			p.setLocation(location);
//			
//			Map<String, Object> map = new HashMap<>();
//			map.put("name", "jh");
////			map.put("location", location);
//			map.put("jd", jd);
//			map.put("wd", wd);
//			zGisMapper.insertData(map);
//		}
//		peopleMapper.insertList(recordList);
		ExecutorService es = Executors.newFixedThreadPool(20);

		List<Callable<String>> jobList = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
		    final int count = i;
		    Callable<String> callable = new Callable<String>() {
		    @Override
		    	public String call() throws Exception {
		    		for (int j = 0; j < 100; j++) {
		    			double jd = Math.random()+120;
		    			double wd = Math.random()+30;
//		    			String location = "point("+jd+" "+wd+")";
		    			
		    			Map<String, Object> map = new HashMap<>();
		    			map.put("name", "jh");
		    			map.put("jd", jd);
		    			map.put("wd", wd);
		    			zGisMapper.insertData(map);
					}
					return null;
		       	}
		   };
		    jobList.add(callable);
		 }
		
		List<Future<String>> results = es.invokeAll(jobList);
		es.shutdown();
	}

}
