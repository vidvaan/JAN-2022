package com.ciq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ciq.dao.EmployeeDAO;

@SpringBootApplication
public class Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public void run(String... args) throws Exception {
		employeeDAO.findAll().forEach(System.out::println);
		
	}

}
