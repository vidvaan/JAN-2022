package com.ciq;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ciq.contrller.EmployeeRestController;
import com.ciq.model.Employee;
import com.ciq.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeRestController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	@Test
	  public void testfindAll() throws Exception {
		
	    List<Employee> employees = getAllEmployees();

	    Mockito.when(employeeService.findAll()).thenReturn(employees);

	    mockMvc.perform(get("/emp/findAll"))
            .andDo(print())
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$", Matchers.hasSize(3)))
	        .andExpect(jsonPath("$[0].ename", Matchers.is("Balaji")))
	        .andExpect(jsonPath("$[0].eid", Matchers.is(1)))
	        .andExpect(jsonPath("$[0].esal", Matchers.is(20000.0)))
	        .andExpect(jsonPath("$[1].ename", Matchers.is("Rehman")))
	        .andExpect(jsonPath("$[1].eid", Matchers.is(2)))
	        .andExpect(jsonPath("$[1].esal", Matchers.is(30000.0)))
	        .andExpect(jsonPath("$[2].ename", Matchers.is("Ram")))
            .andExpect(jsonPath("$[2].eid", Matchers.is(3)))
            .andExpect(jsonPath("$[2].esal", Matchers.is(40000.0)));
	  }
	
	
	
	@Test
	  public void testfindById() throws Exception {
	
		List<Employee> employees = getAllEmployees();

		Mockito.when(employeeService.findById(1)).thenReturn(employees.get(0));
		Mockito.when(employeeService.findById(2)).thenReturn(employees.get(1));
		Mockito.when(employeeService.findById(3)).thenReturn(employees.get(2));

		mockMvc.perform(get("/emp/findById/1"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.ename", Matchers.is("Balaji")))
			.andExpect(jsonPath("$.eid", Matchers.is(1)))
			.andExpect(jsonPath("$.esal", Matchers.is(20000.0)));
		
		mockMvc.perform(get("/emp/findById/2"))
		.andDo(print())
		.andExpect(status().isOk())
			.andExpect(jsonPath("$.ename", Matchers.is("Rehman")))
			.andExpect(jsonPath("$.eid", Matchers.is(2)))
			.andExpect(jsonPath("$.esal", Matchers.is(30000.0)));
		
		mockMvc.perform(get("/emp/findById/3"))
		.andDo(print())
		.andExpect(status().isOk())
			.andExpect(jsonPath("$.ename", Matchers.is("Ram")))
			.andExpect(jsonPath("$.eid", Matchers.is(3)))
			.andExpect(jsonPath("$.esal", Matchers.is(40000.0)));
	
	}
	
	
	
	
	@Test
	public void createEmployeeAPI() throws Exception 
	{
		
		Employee employee = new Employee(1,"Balaji",30000.00);
		
		doNothing().when(employeeService).save(employee);
		mockMvc.perform( 
		    post("/emp/save")
		      .contentType(MediaType.APPLICATION_JSON)
		      .content(asJsonString(employee))
		      .accept(MediaType.APPLICATION_JSON))
		      .andDo(print())
				.andExpect(status().isCreated())
					.andExpect(jsonPath("$.ename", Matchers.is("Balaji")))
					.andExpect(jsonPath("$.eid", Matchers.is(1)))
					.andExpect(jsonPath("$.esal", Matchers.is(30000.0)));
	}
	
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
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

}
