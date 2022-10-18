package com.createiq;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.createiq.dao.EmployeeDAO;
import com.createiq.model.Employee;
import com.createiq.service.EmployeeServiceImpl;

@SpringBootTest
public class EmployeeServiceMockTest {
	@Mock
	private EmployeeDAO employeeDAO;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;

	private static List<Employee> employees;

	@BeforeAll
	public static void init() {
		employees = new ArrayList<Employee>();
		employees.add(new Employee(1001, "Balaji", 50000.00));
		employees.add(new Employee(1002, "raja", 60000.00));
		employees.add(new Employee(1003, "ram", 70000.00));
	}
	
	@Test
	public void findAll() {
		when(employeeDAO.findAll()).thenReturn(employees);
		assertThat(employeeService.findAll(), hasSize(3));
		verify(employeeDAO,times(1)).findAll();
		verify(employeeDAO).findAll();
	}
	
	
}
