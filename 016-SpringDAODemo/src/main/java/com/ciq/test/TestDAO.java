package com.ciq.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ciq.dao.EmployeeDAO;

public class TestDAO {
	
	public static void main(String[] args)  {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeDAO employeeDAO = (EmployeeDAO) applicationContext.getBean("employeeDAOImpl");
	
	    //employeeDAO.findAll().forEach(System.out::println);
		System.out.println(employeeDAO.findById(1));
	}

}
