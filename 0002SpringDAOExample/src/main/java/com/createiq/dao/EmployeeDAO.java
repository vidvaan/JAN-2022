package com.createiq.dao;

import java.util.List;

import com.createiq.model.Employee;

public interface EmployeeDAO {
	public void save(Employee employee);
	public void update(Employee employee);
	public void delete(int eid);
	public List<Employee> findAll();
	public Employee findById(Integer eid);
	public List<String> findAllDataStr();
	
}
