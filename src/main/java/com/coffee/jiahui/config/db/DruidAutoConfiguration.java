 package com.coffee.jiahui.config.db;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnProperty(prefix = "spring.datasource.druid", name = "url")
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidAutoConfiguration {

	@Autowired
	private DruidProperties properties;
	
	@Bean
	public DruidDataSource dataSource(){
		
		DruidDataSource dataSource = new DruidDataSource();
		
		 try {
	            dataSource.setUrl(properties.getUrl());
	            dataSource.setUsername(properties.getUserName());
	            dataSource.setPassword(properties.getPassword());
	            if (properties.getInitialSize() > 0) {
	                dataSource.setInitialSize(properties.getInitialSize());
	            }
	            if (properties.getMinIdle() > 0) {
	                dataSource.setMinIdle(properties.getMinIdle());
	            }
	            if (properties.getMaxActive() > 0) {
	                dataSource.setMaxActive(properties.getMaxActive());
	            }
	            dataSource.setTestOnBorrow(properties.isTestOnBorrow());

	            dataSource.setFilters(properties.getFilters());
	            dataSource.setPoolPreparedStatements(true);

	            dataSource.setMaxWait(60000);
	            dataSource.setTimeBetweenEvictionRunsMillis(60000);
	            dataSource.setMinEvictableIdleTimeMillis(30000);
	            dataSource.setTestWhileIdle(true);
	            dataSource.setTestOnBorrow(false);
	            dataSource.setTestOnReturn(false);
	            dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);

	            dataSource.init();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return dataSource;
	}
	
	@Bean
    public DataSourceTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
