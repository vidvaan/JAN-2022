package com.createiq.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.createiq.controller.EmployeeController;
import com.createiq.model.Employee;

public class IntegrationTest extends SprintTestRunner{
	
	@Autowired
	private EmployeeController employeeController;
	
	@Test
	public void saveUpdateDelete() {
		Employee employee = new Employee(1111, "Balaji", 20000.00);
		employeeController.save(employee);
		
		Employee emp = employeeController.findById(1111);
		assertThat(emp.getEid(), is(equalTo(1111)));
		assertThat(emp.getEname(), is(equalTo("Balaji")));
		
		employee.setEname("Raja");
		
		employeeController.update(employee);
		
		 emp = employeeController.findById(1111);
		assertThat(emp.getEid(), is(equalTo(1111)));
		assertThat(emp.getEname(), is(equalTo("Raja")));
		
		employeeController.deleteById(1111);
	}

}
