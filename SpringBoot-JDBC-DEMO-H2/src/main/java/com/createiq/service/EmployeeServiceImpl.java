package com.createiq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.dao.EmployeeDAO;
import com.createiq.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public void save(Employee employee) {
		employeeDAO.save(employee);
		
	}

	@Override
	public void update(Employee employee) {
		employeeDAO.update(employee);
		
	}

	@Override
	public void delete(int eid) {
		employeeDAO.delete(eid);
		
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = employeeDAO.findAll();
		if(employees.isEmpty()) {
			return null;
		}
		return employees;
	}

	@Override
	public Employee findById(Integer eid) {
		return employeeDAO.findById(eid);
	}

}
