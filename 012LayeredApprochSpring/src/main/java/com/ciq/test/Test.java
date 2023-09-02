package com.ciq.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ciq.config.SpringConfig;
import com.ciq.controller.EmployeeController;
import com.ciq.model.Employee;

public class Test {
	public static void main(String[] args) {
		//ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");	
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		EmployeeController employeeController = (EmployeeController) ac.getBean("ec");
		Employee employee = new Employee(2,"Balaji",20000.00);
		employeeController.save(employee);
	}

}
