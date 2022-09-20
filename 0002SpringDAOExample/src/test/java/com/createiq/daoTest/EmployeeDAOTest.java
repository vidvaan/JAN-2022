package com.createiq.daoTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.createiq.dao.EmployeeDAO;
import com.createiq.model.Employee;

public class EmployeeDAOTest {
	
	private static EmployeeDAO employeeDAO;

	@BeforeClass
	public static void setUp() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		 employeeDAO = (EmployeeDAO) applicationContext.getBean("employeeDAOImpl");
	}

	@Test
	@Ignore
	public void addTest() {
		employeeDAO.save(new Employee(1006,"Roy",34000.00));
	}
	
	@Test
	@Ignore
	public void updateTest() {
		employeeDAO.update(new Employee(1005,"Raja Ram",44000.00));
	}
	
	@Test
//	@Ignore
	public void deleteTest() {
		employeeDAO.delete(1005);
	}
	
	@Test
	@Ignore
	public void findByIdTest() {
		Employee employee = employeeDAO.findById(1005);
		assertEquals(1005, employee.getEid());
		assertEquals("Raja Ram", employee.getEname());
	}
	@Test
	public void findAllTest() {
		List<Employee> employees = employeeDAO.findAll();
		assertEquals(false, employees.isEmpty());
	}

}
