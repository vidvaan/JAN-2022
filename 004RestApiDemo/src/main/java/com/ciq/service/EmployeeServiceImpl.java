package com.ciq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciq.dao.EmployeeDAO;
import com.ciq.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
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
	public void deleteById(Integer eid) {
		employeeDAO.deleteById(eid);
	}

	@Override
	public Employee findById(Integer eid) {
		Employee employee = null;
		try {
			employee = employeeDAO.findById(eid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return employee;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

}
