package com.createiq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createiq.exception.EmployeeNotFoundException;
import com.createiq.model.Employee;
import com.createiq.service.EmployeeService;

@RestController
@RequestMapping("/rest")
@CrossOrigin(origins = "*")
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("findAll")
	public List<Employee> home() {
		return employeeService.findAll();
	}
	
	@GetMapping("findById/{eid}")
	public Employee findById(@PathVariable("eid") Integer eid) {
		Employee employee = null;
		try {
		  employee = employeeService.findById(eid);
		  return employee;
		}catch (Exception e) {
			throw new EmployeeNotFoundException("With this id no record found in Database.");
		}
	}
	
	
	@PostMapping("add")
	public String add(@RequestBody Employee employee) {
		 employeeService.save(employee);
		 return "Inserted Successfully";
	}
	
	@PutMapping("update")
	public String update(@RequestBody Employee employee) {
		 employeeService.update(employee);
		 return "Updated Successfully";
	}
	
	@DeleteMapping("delete/{eid}")
	public String delete(@PathVariable("eid") Integer eid) {
		 employeeService.delete(eid);
		 return "Deleted Successfully";
	}
}
