package com.createiq.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doNothing;
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
public class ServiceTest{
	
	@Mock
	private EmployeeDAO employeeDAO;
	
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	
	
	private static List<Employee> employees;
	
	@BeforeClass
	public static void setUp() {
		employees = new ArrayList<Employee>();
		employees.add(new Employee(1001, "Balaji", 20000.00));
		employees.add(new Employee(1002, "Ram", 20000.00));
		employees.add(new Employee(1003, "Roy", 20000.00));
	}
	
	@Test
	public void findAll() {
		when(employeeDAO.findAll()).thenReturn(employees);
		assertThat(employeeService.findAll(), is(hasSize(3)));
	}
	
	
	@Test
	public void addUpdateDelete() {
		doNothing().when(employeeDAO).save(employees.get(0));
		doNothing().when(employeeDAO).update(employees.get(0));
		doNothing().when(employeeDAO).deleteById(1001);
		employeeService.save(employees.get(0));
		employeeService.update(employees.get(0));
		employeeService.deleteById(1001);
		verify(employeeDAO).save(employees.get(0));
		verify(employeeDAO).update(employees.get(0));
		verify(employeeDAO).deleteById(1001);
		
	}
	
	

}
