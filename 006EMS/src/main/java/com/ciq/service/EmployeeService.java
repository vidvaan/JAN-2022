package com.ciq.service;

import java.util.List;

import com.ciq.entity.Employee;

public interface EmployeeService {
	 public Employee save(Employee employee);
	   
	   public Employee update(Employee employee);
	   
	   public void deleteById(Long eid);
	   
	   public Employee findById(Long eid);
	   
	   
	   public List<Employee> findAll();
}
