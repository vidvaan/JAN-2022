package com.createiq.service;

import java.util.List;

import com.createiq.model.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public void add(Employee employee);
	
	public void update(Employee employee);
	
	public void delete(Integer eid);
	
	public Employee findById(Integer eid);

}
