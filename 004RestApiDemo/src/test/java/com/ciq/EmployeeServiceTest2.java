package com.ciq;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.allOf;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ciq.dao.EmployeeDAO;
import com.ciq.model.Employee;
import com.ciq.service.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest2 {

	@Mock
	private EmployeeDAO employeeDAO;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Test
	void testFindAllEmployees() {

		when(employeeDAO.findAll()).thenReturn(getAllEmployees());

		// test
		List<Employee> empList = employeeService.findAll();

		assertThat(empList, hasSize(3));
		verify(employeeDAO, times(1)).findAll();
	}

	@Test
	void findById() {
		when(employeeDAO.findById(1)).thenReturn(getAllEmployees().get(0));
		when(employeeDAO.findById(2)).thenReturn(getAllEmployees().get(1));
		when(employeeDAO.findById(3)).thenReturn(getAllEmployees().get(2));

		assertThat(employeeService.findById(1),
				allOf(hasProperty("ename", equalTo("Balaji")), hasProperty("esal", equalTo(20000.00))));

		assertThat(employeeService.findById(2),
				allOf(hasProperty("ename", equalTo("Rehman")), hasProperty("esal", equalTo(30000.00))));

		assertThat(employeeService.findById(3),
				allOf(hasProperty("ename", equalTo("Ram")), hasProperty("esal", equalTo(40000.00))));

		verify(employeeDAO, times(1)).findById(1);
		verify(employeeDAO, times(1)).findById(2);
		verify(employeeDAO, times(1)).findById(3);

	}
	
	
	@Test
	public void saveTest() {
		Employee e1  = new Employee(1, "Balaji", 20000.00);
		doNothing().when(employeeDAO).save(e1);
		employeeService.save(e1);
		verify(employeeDAO, times(1)).save(e1);
	}
	
	@Test
	public void updateTest() {
		Employee e1  = new Employee(1, "Balaji", 20000.00);
		doNothing().when(employeeDAO).update(e1);
		employeeService.update(e1);
		verify(employeeDAO, times(1)).update(e1);
	}
	
	
	@Test
	public void deleteTest() {
		doNothing().when(employeeDAO).deleteById(1);
		employeeService.deleteById(1);
		verify(employeeDAO, times(1)).deleteById(1);
	}

	private List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		Employee empOne = new Employee(1, "Balaji", 20000.00);
		Employee empTwo = new Employee(2, "Rehman", 30000.00);
		Employee empThree = new Employee(3, "Ram", 40000.00);

		list.add(empOne);
		list.add(empTwo);
		list.add(empThree);
		return list;
	}
	
	
	

//	@Test
//	public void endtoendTest() {
//		employeeService.save(new Employee(10, "Jaya", 20000.00));
//		//Assertions.assertEquals("Jaya", employeeService.findById(10).getEname());
//		
//		assertThat( employeeService.findById(10).getEname(), equalTo("Jaya"));
//		employeeService.update(new Employee(10, "Jaya Rao", 20000.00));
//		Assertions.assertEquals("Jaya Rao", employeeService.findById(10).getEname());
//		
//		 assertThat(employeeService.findById(10), allOf(
//	                hasProperty("ename", equalTo("Jaya Rao")),
//	                hasProperty("esal", equalTo(20000.00))
//	        ));
//		employeeService.deleteById(10);
//		Assertions.assertNull(employeeService.findById(10));
//		
//		assertThat(employeeService.findById(10),nullValue());
//		
//		
//	}

}
