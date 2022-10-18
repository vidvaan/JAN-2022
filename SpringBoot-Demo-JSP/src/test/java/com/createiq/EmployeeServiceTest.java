package com.createiq;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.createiq.model.Employee;
import com.createiq.service.EmployeeService;
@SpringBootTest
public class EmployeeServiceTest{
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void findAllTest() {
		assertThat(employeeService.findAll(), hasSize(9));
		assertThat(employeeService.findAll(),hasItems(Matchers.<Employee>hasProperty("eid", is(1001)),Matchers.<Employee>hasProperty("ename", is("Balaji G")),  Matchers.<Employee>hasProperty("esal", is(50000.0))));
	}

}
