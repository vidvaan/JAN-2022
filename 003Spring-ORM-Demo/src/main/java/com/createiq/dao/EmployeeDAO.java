package com.createiq.dao;

import java.util.List;

import com.createiq.model.Employee;

public interface EmployeeDAO {
	public void save(Employee employee);
	
	public void update(Employee employee);
	
	public void deleteById(Integer eid);

	public List<Employee> findAll();
}
