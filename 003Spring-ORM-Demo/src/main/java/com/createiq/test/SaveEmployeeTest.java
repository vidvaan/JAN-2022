package com.createiq.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.createiq.controller.EmployeeController;
import com.createiq.model.Employee;

public class SaveEmployeeTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		
		//ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		EmployeeController employeeController = (EmployeeController) applicationContext.getBean("empController");

		Employee employee = new Employee(1002, "Balaji", 20000.00);

		employeeController.save(employee);
		
		System.out.println("Success");
	}

}
