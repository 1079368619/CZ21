package com.yc.spring.bank;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class JdbcConfig {

	@Resource
	private DBProperties dbc;

	@Resource
	DriverManagerDataSource dataSource;
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName(dbc.getDriverClassName());
		dmds.setUrl(dbc.getUrl());
		dmds.setPassword(dbc.getPassword());
		dmds.setUsername(dbc.getUsername());
		return dmds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public DataSourceTransactionManager dstm() {
		return new DataSourceTransactionManager(dataSource);
	}
}
