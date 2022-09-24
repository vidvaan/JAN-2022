package com.createiq.service;

import java.util.List;

import com.createiq.model.Employee;

public interface EmployeeService {
	
	public Employee findById(Integer eid);
	
	public List<Employee> findAll();

}
