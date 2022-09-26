package com.createiq.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.createiq.controller.EmployeeController;
import com.createiq.model.Employee;

public class SelectAllEmployeeTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

		// ApplicationContext applicationContext = new
		// AnnotationConfigApplicationContext(SpringConfig.class);

		EmployeeController employeeController = (EmployeeController) applicationContext.getBean("empController");

		employeeController.findAll().forEach(System.out::println);

		System.out.println("Success");
	}

}
