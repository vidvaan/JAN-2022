package com.createiq.dao;

import com.createiq.model.Employee;

public interface EmployeeDAO {
	public void save(Employee employee);
	public void update(Employee employee);
	public void delete(int eid);
}
