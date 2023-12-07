package com.createiq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.createiq.entity.Employee;
import com.createiq.repository.EmployeeRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		Employee employee1 = new Employee();
		employee1.setEname("Balaji");
		employee1.setEsal(20000.00);
		
		Employee employee2 = new Employee();
		employee2.setEname("Raja");
		employee2.setEsal(20000.00);
		
		Employee employee3 = new Employee();
		employee3.setEname("Rama");
		employee3.setEsal(20000.00);
		
		Employee employee4 = new Employee();
		employee4.setEname("Roy");
		employee4.setEsal(20000.00);
		
		Employee employee5 = new Employee();
		employee5.setEname("Jhon");
		employee5.setEsal(20000.00);
		
		List<Employee> employees = List.of(employee1,employee2,employee3,employee4,employee5);
		
		employeeRepository.saveAll(employees);
		
	}

}
