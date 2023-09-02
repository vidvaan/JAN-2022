package com.ciq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ciq.dao.EmployeeDAO;
import com.ciq.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	@Qualifier("employeeDAOImpl")
	private EmployeeDAO employeeDAO;
	

	@Override
	public void save(Employee employee) {
		System.out.println("Employee Service Save Called: " + employee);
		employeeDAO.save(employee);
	}

}
