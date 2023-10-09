package com.ciq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciq.entity.Address;
import com.ciq.entity.Employee;
import com.ciq.repository.AddressRepository;
import com.ciq.repository.DepartmentRepository;
import com.ciq.repository.EmployeeRepository;
import com.ciq.repository.ProjectRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public void save(Employee employee) {
		addressRepository.save(employee.getAddress());
		departmentRepository.save(employee.getDepartment());
		employee.getProjects().forEach(project -> projectRepository.save(project));
		employeeRepository.save(employee);
	}

	@Override
	public void update(Employee employee) {
		addressRepository.save(employee.getAddress());
		departmentRepository.save(employee.getDepartment());
		employee.getProjects().forEach(project -> projectRepository.save(project));
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(Long eid) {
		Optional<Employee> empOptional = employeeRepository.findById(eid);
		if (empOptional.isPresent()) {
			Employee employee = empOptional.get();
			Address address = employee.getAddress();
            employeeRepository.delete(employee);
			addressRepository.deleteById(address.getAid());
		}
		
	}

	@Override
	public Employee findById(Long eid) {

		Optional<Employee> optional = employeeRepository.findById(eid);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

}
