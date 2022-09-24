package com.createiq.service;

import java.util.List;

import com.createiq.dao.EmployeeDAO;
import com.createiq.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	public Employee findById(Integer eid) {
		return employeeDAO.findById(eid);
	}

	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

}
