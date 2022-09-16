package com.createiq.service;

import com.createiq.model.Employee;

public interface EmployeeService {
	public void save(Employee employee);
	public void update(Employee employee);
	public void delete(int eid);
}
