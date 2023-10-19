package com.ciq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.entity.Employee;
import com.ciq.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmployeeController {

	

	@RequestMapping("/log")
	public String log() {
		// Logging various log level messages
		log.trace("Log level: TRACE");
		log.info("Log level: INFO");
		log.debug("Log level: DEBUG");
		log.error("Log level: ERROR");
		log.warn("Log level: WARN");

		return "Hey! You can check the output in the logs";
	}

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/findAll")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/findById/{eid}")
	public Employee findById(@PathVariable Long eid) {
		return employeeService.findById(eid);
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Employee employee) {

		//
		throw new NullPointerException("Predifined Excption");
//		Employee emp = null;
//		try {
//		    emp = employeeService.save(employee);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public Employee update(@RequestBody Employee employee) {
		return employeeService.update(employee);
	}

	@DeleteMapping("/delete/{eid}")
	public String delete(@PathVariable Long eid) {
		employeeService.deleteById(eid);
		return "Deleted Successfully";
	}

	@GetMapping("/findAll/{pageNum}/{numOfRecords}")
	public List<Employee> findAllPaging(@PathVariable Integer pageNum, @PathVariable Integer numOfRecords) {
		return employeeService.findAllWithPaging(pageNum - 1, numOfRecords);
	}

}
