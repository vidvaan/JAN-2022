package com.createiq.daoTest;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.createiq.model.Employee;
import com.createiq.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/spring.xml")
public class EmployeeServiceTest {
    @Autowired
	private EmployeeService employeeService;
    @Test
    @Ignore
    public void testAdd() {
    	employeeService.save(new Employee(1008, "Singam", 230000.00));
    }
    
    @Test
    public void testDelete() {
    	employeeService.delete(1008);
    }
}
