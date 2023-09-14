package com.ciq.dao;

import java.util.List;

import com.ciq.model.Employee;

public interface EmployeeDAO {
   public void save(Employee employee);
   
   public void update(Employee employee);
   
   public void deleteById(Integer eid);
   
   public Employee findById(Integer eid);
   
   
   public List<Employee> findAll();
}
