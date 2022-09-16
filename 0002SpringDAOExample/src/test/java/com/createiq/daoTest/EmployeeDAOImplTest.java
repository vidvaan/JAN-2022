package com.createiq.daoTest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.createiq.dao.EmployeeDAO;

public class EmployeeDAOImplTest {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		
		EmployeeDAO employeeDAO = (EmployeeDAO) applicationContext.getBean("employeeDAOImpl");
		
		List<String> allRecords = employeeDAO.findAllDataStr();
		
		allRecords.forEach(System.out::println);
	}

}
