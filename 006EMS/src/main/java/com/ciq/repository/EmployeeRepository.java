package com.ciq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciq.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
