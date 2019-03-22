package com.coffee.jiahui.config.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Cache;

@Configuration
public class CacheConfig {

	@Bean(name = "oneCacheManager")
	public CacheManager cacheManager(){
		
		CacheManager cacheManager = CacheManager.create(getClass().getResource("/ehcache.xml"));
//		Cache cache = new Cache("demoCache", 10000, "LRU", true, "D:/ehcache2", false, 120, 120, false, 120, registeredEventListeners);
//		Cache cache1 = new Cache("cache1", 5000, true, true, 36000, 36000);
//		Cache cache2 = new Cache("cache2", 5000, true, true, 36000, 36000);
//		Cache cache3 = new Cache("cache3", 5000, true, true, 36000, 36000);
//		cacheManager.addCache(cache1);
//		cacheManager.addCache(cache2);
//		cacheManager.addCache(cache3);
//		Cache demoCache = cacheManager.getCache("demoCache");
		return cacheManager;
	}
	
}
