package com.ciq;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import java.util.List;

import  org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ciq.model.Employee;
import com.ciq.service.EmployeeService;
@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void configTest() {
		//Assertions.assertNotNull(employeeService);
		assertThat(employeeService,notNullValue());
	}
	
	@Test
	public void endtoendTest() {
		employeeService.save(new Employee(10, "Jaya", 20000.00));
		//Assertions.assertEquals("Jaya", employeeService.findById(10).getEname());
		
		assertThat( employeeService.findById(10).getEname(), equalTo("Jaya"));
		employeeService.update(new Employee(10, "Jaya Rao", 20000.00));
		Assertions.assertEquals("Jaya Rao", employeeService.findById(10).getEname());
		
		 assertThat(employeeService.findById(10), allOf(
	                hasProperty("ename", equalTo("Jaya Rao")),
	                hasProperty("esal", equalTo(20000.00))
	        ));
		employeeService.deleteById(10);
		Assertions.assertNull(employeeService.findById(10));
		
		assertThat(employeeService.findById(10),nullValue());
		
		
	}
	
	
	@Test
	void testFindAllEmployees() {

		// test
		List<Employee> empList = employeeService.findAll();

		assertThat(empList, hasSize(3));
	}
	
	
	

}
