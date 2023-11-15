package com.ciq;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import  org.junit.jupiter.api.Assertions;

import com.ciq.model.Employee;
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class EmployeeApiIntegrationTest{
	
	@LocalServerPort
    int randomServerPort;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@Test
	public void testCreateReadDelete() {
		String url = "http://localhost:"+randomServerPort+"/emp";
		
		Employee employee = new Employee(23,"Balaji",40000.00);
		
		String saveUrl = url+"/save";
		ResponseEntity<Employee> entity = restTemplate.postForEntity(saveUrl, employee, Employee.class);
		System.out.println(employee);
		
//		String findByIdUrl = url+"/findById/22";
//		
//		assertThat(restTemplate.getForObject(findByIdUrl, Employee.class), allOf(
//                hasProperty("ename", equalTo("Balaji")),
//                hasProperty("esal", equalTo(20000.00))
//		));
		
		employee.setEname("rama");
		String updateUrl = url+"/update";
		//ResponseEntity<Employee> entity2 = 
				restTemplate.put(updateUrl, employee, Employee.class);
		
		
		String deleteUrl = url+"/delete/22";
		restTemplate.delete(deleteUrl);
		
		
//		assertThat(restTemplate.getForObject(findByIdUrl, Employee.class), nullValue());
		
		
		
		
	}
	
	
	
	

}
