package com.createiq.dao;

import java.util.List;

import com.createiq.model.Employee;

public interface EmployeeDAO {
	
	public Employee findById(Integer eid);
	public List<Employee> findAll();
}
