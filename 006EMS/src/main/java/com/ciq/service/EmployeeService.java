package com.ciq.service;

import java.util.List;

import com.ciq.entity.Employee;

public interface EmployeeService {
	 public void save(Employee employee);
	   
	   public void update(Employee employee);
	   
	   public void deleteById(Long eid);
	   
	   public Employee findById(Long eid);
	   
	   
	   public List<Employee> findAll();
}
