package com.createiq.service;

import java.util.List;

import com.createiq.model.Employee;

public interface EmployeeService {
	public void save(Employee employee);

	public void update(Employee employee);

	public void delete(int eid);

	public List<Employee> findAll();

	public Employee findById(Integer eid);
}
