package com.coffee.jiahui.config.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfiguration {

	@Bean
	public FilterRegistrationBean myFirstFilterRegistration(){
		
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setName("authFilter");
        MyFirstFilter authFilter = new MyFirstFilter();
        filterRegistrationBean.setFilter(authFilter);
        filterRegistrationBean.setOrder(1);
        List<String> urlList = new ArrayList<String>();
        urlList.add("/testFilter");
        filterRegistrationBean.setUrlPatterns(urlList);
        return filterRegistrationBean;
		
	}
	
}
