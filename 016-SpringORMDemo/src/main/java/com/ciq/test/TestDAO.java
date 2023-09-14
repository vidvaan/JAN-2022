package com.ciq.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ciq.dao.EmployeeDAO;
import com.ciq.model.Employee;

public class TestDAO {
	
	public static void main(String[] args)  {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeDAO employeeDAO = (EmployeeDAO) applicationContext.getBean("employeeDAOImpl");
	
//		Employee e1 = new Employee();
//		e1.setEname("Balaji");
//		e1.setEsal(20000.00);
//		
//		Employee e2 = new Employee();
//		e2.setEname("Raja");
//		e2.setEsal(20000.00);
//		
//		employeeDAO.save(e1);
//		employeeDAO.save(e2);
		
	    employeeDAO.findAll().forEach(System.out::println);
		System.out.println(employeeDAO.findById(1));
	}

}
