package com.createiq.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.createiq.config.SpringConfig;
import com.createiq.controller.EmployeeController;
import com.createiq.model.Employee;

public class Test {
	
	public static void main(String[] args) {
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
		EmployeeController employeeController = (EmployeeController) applicationContext.getBean("employeeController");
		Employee employee = new Employee(1001, "Balaji", 20000.00);
		employeeController.save(employee);
	}

}
