package com.createiq.service;

import java.util.List;

import com.createiq.model.Employee;

public interface EmployeeService {
	public void save(Employee employee);

	public void update(Employee employee);

	public List<Employee> findAll();
	
	public void deleteById(Integer eid);

	public Employee findByEid(Integer eid);
}
