package com.createiq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.createiq.model.Employee;
import com.createiq.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	public void save(Employee employee) {
		employeeService.save(employee);
	}

	public void update(Employee employee) {
		employeeService.update(employee);
	}

	public void delete(int eid) {
		employeeService.delete(eid);
	}
	
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	public Employee findById(Integer eid) {
		return employeeService.findById(eid);
	}

}
