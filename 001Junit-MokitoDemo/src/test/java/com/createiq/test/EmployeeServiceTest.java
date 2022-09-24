package com.createiq.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.createiq.dao.EmployeeDAO;
import com.createiq.model.Employee;
import com.createiq.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
	
	
	private static List<Employee> employees;
	
	@BeforeClass
	public static void init() {
		employees = new ArrayList<Employee>();
		employees.add(new Employee(1001, "Balaji"));
		employees.add(new Employee(1002,"raja"));
		employees.add(new Employee(1003,"ram"));
	}
	
	@Mock
	private EmployeeDAO employeeDAO;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	@Test
	public void findAllTest() {
		when(employeeDAO.findAll()).thenReturn(employees);
		assertThat(employeeService.findAll(), hasSize(3));
		verify(employeeDAO,times(1)).findAll();
		verify(employeeDAO).findAll();
	}
	
	

	@Test
	public void findById() {
		when(employeeDAO.findById(1001)).thenReturn(employees.get(0));
		assertThat(employeeService.findById(1001),any(Employee.class));
		assertThat(employeeService.findById(1001).getEname(), is("Balaji"));
	}
	
	
	
	

}
