package com.createiq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createiq.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
