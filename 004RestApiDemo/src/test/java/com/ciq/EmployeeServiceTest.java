package com.ciq;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ciq.model.Employee;
import com.ciq.service.EmployeeService;

public class EmployeeServiceTest extends ApplicationTests {

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void configTest() {
		Assertions.assertNotNull(employeeService);
	}
	
	@Test
	public void endtoendTest() {
		employeeService.save(new Employee(10, "Jaya", 20000.00));
		Assertions.assertEquals("Jaya", employeeService.findById(10).getEname());
		employeeService.update(new Employee(10, "Jaya Rao", 20000.00));
		Assertions.assertEquals("Jaya Rao", employeeService.findById(10).getEname());
		employeeService.deleteById(10);
		Assertions.assertNull(employeeService.findById(10));
	}
	
	
	

}
