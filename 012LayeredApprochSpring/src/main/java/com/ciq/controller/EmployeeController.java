package com.ciq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.ciq.model.Employee;
import com.ciq.service.EmployeeService;
@Controller("ec")
//<bean id="employeeController" class="com.ciq.controller.EmployeeController"></bean>
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;


	public void save(Employee employee) {
		System.out.println("Employee Controller Save Called: "+employee);
		employeeService.save(employee);
	}

}
