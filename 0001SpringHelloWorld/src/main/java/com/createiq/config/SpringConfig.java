package com.createiq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.createiq.controller.EmployeeController;
import com.createiq.dao.EmployeeDAO;
import com.createiq.dao.EmployeeDAOImpl;
import com.createiq.service.EmployeeService;
import com.createiq.service.EmployeeServiceImpl;

@Configuration
@ComponentScan(basePackages="com.createiq")
public class SpringConfig {
	
	@Bean
	public EmployeeDAO employeeDAO() {
		return new EmployeeDAOImpl();
	}
	
	
	@Bean
	public EmployeeService employeeService() {
		return new EmployeeServiceImpl();
	}
	
	@Bean
	public EmployeeController employeeController() {
		return new EmployeeController();
	}
	

}
