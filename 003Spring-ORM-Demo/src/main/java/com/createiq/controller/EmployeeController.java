package com.createiq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.createiq.model.Employee;
import com.createiq.service.EmployeeService;
@Controller("empController")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	

	public void save(Employee employee) {
		System.out.println("Employee Controller Save Called :");
		employeeService.save(employee);
		
	}
	
	public void update(Employee employee) {
		System.out.println("Employee Controller Update Called :");
		employeeService.update(employee);
		
	}
	
	public List<Employee> findAll(){
		return employeeService.findAll();
	}

}
