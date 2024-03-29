package com.ciq.contrller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.bean.ResponceBean;
import com.ciq.model.Employee;
import com.ciq.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/findAll")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/findById/{eid}")
	public Employee findById(@PathVariable Integer eid) {
		return employeeService.findById(eid);
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Employee employee) {
		try {
			employeeService.save(employee);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(employee, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public Employee update(@RequestBody Employee employee) {
		employeeService.update(employee);
		return employee;
	}

	@DeleteMapping("/delete/{eid}")
	public String delete(@PathVariable Integer eid) {
		employeeService.deleteById(eid);
		return "Deleted Successfully";
	}

}
