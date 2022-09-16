package com.createiq.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.createiq.controller.EmployeeController;
import com.createiq.dao.EmployeeDAO;
import com.createiq.dao.EmployeeDAOImpl;
import com.createiq.service.EmployeeService;
import com.createiq.service.EmployeeServiceImpl;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.createiq")
@PropertySource(value = { "db.properties" })
public class SpringConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		System.out.println("Url : "+env.getProperty("jdbcUrl"));
		HikariDataSource hd = new HikariDataSource();
		hd.setJdbcUrl(env.getProperty("jdbcUrl"));
		hd.setUsername(env.getProperty("jdbcUsername"));
		hd.setPassword(env.getProperty("jdbcPassword"));
		hd.setDriverClassName(env.getProperty("jdbcDriver"));
		return hd;
	}
	
	
	

}
