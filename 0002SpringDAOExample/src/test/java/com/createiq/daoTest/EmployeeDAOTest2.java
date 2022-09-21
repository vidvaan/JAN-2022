package com.createiq.daoTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.createiq.dao.EmployeeDAO;
import com.createiq.model.Employee;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/spring.xml")
public class EmployeeDAOTest2 {

	@Autowired
	private  EmployeeDAO employeeDAO;

	
    @Test
	public void daoTest() {
		System.out.println(employeeDAO);
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
