package com.createiq.dao;

import org.springframework.stereotype.Repository;

import com.createiq.model.Employee;
//@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	public void save(Employee employee) {
        System.out.println("Employee DAO -> Save Method Called");
	}

}
