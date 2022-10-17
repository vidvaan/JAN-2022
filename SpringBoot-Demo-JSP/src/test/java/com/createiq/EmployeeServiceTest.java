package com.createiq;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.createiq.controller.HomeController;
import com.createiq.service.EmployeeService;

@SpringBootTest
public class EmployeeServiceTest{
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void findAllTest() {
		assertThat(employeeService.findAll(), hasSize(9));
	}

}
