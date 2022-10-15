package com.createiq.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.createiq.model.Employee;

//@Service
public class EmployeeServiceImpl2 implements EmployeeService {

	private static List<Employee> employees = null;

	static {
		employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "Balaji", 20000.00));
		employees.add(new Employee(2, "Ram", 20000.00));
		employees.add(new Employee(3, "Joy", 20000.00));
		employees.add(new Employee(4, "Roy", 20000.00));
		employees.add(new Employee(5, "Jhon", 20000.00));

	}

	@Override
	public List<Employee> findAll() {
		return employees;
	}

	@Override
	public void add(Employee employee) {
		employees.add(employee);
	}

	@Override
	public void update(Employee employee) {
		ListIterator<Employee> iterator = employees.listIterator();
		while (iterator.hasNext()) {
			Employee emp = (Employee) iterator.next();
			if (employee.getEid() == emp.getEid()) {
				iterator.set(employee);
			}
		}

	}

	@Override
	public void delete(Integer eid) {
		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {
			Employee employee = (Employee) iterator.next();
			if (employee.getEid() == eid) {
				iterator.remove();
			}
		}
	}

	@Override
	public Employee findById(Integer eid) {
		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {
			Employee employee = (Employee) iterator.next();
			if (employee.getEid() == eid) {
				return employee;
			}
		}
		return null;
	}

}
