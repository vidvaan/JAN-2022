package com.createiq.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.createiq.controller.EmployeeController;
import com.createiq.model.Employee;

public class UpdateEmployeeTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		
		//ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		EmployeeController employeeController = (EmployeeController) applicationContext.getBean("empController");

		Employee employee = new Employee(1005, "Mahesh", 20000.00);

		employeeController.update(employee);
		
		System.out.println("Success");
	}

}
