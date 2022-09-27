package com.createiq.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.createiq.controller.EmployeeController;
import com.createiq.dao.EmployeeDAO;
import com.createiq.service.EmployeeService;

public class AppInitTest extends SprintTestRunner{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeController employeeController;

	@Test
	public void hibernateTemplate_init_test() {
		System.out.println(hibernateTemplate);
		assertThat(hibernateTemplate, notNullValue());
	}
	
	@Test
	public void employeeDAO_init_test() {
		assertThat(employeeDAO, notNullValue());
	}
	
	
	@Test
	public void employeeService_init_test() {
		assertThat(employeeService, notNullValue());
	}
	
	@Test
	public void employeeController_init_test() {
		assertThat(employeeController, notNullValue());
	}

}
