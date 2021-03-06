package com.coffee.jiahui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
//@EnableConfigurationProperties
@MapperScan(basePackages = "com.coffee.jiahui.mapper")
@EnableCaching
public class JiahuiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JiahuiDemoApplication.class, args);
	}
}
