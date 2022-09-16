package com.createiq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.createiq.model.Employee;
import com.createiq.service.EmployeeService;

//@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	public void save(Employee employee) {
		System.out.println("Employee Controller -> Save Method Called");
		employeeService.save(employee);
	}

}
