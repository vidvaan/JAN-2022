package com.ciq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ciq.entity.Address;
import com.ciq.entity.Employee;
import com.ciq.exception.EmployeNotFoundException;
import com.ciq.repository.AddressRepository;
import com.ciq.repository.DepartmentRepository;
import com.ciq.repository.EmployeeRepository;
import com.ciq.repository.ProjectRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
	@Transactional
	public Employee save(Employee employee) {
		addressRepository.save(employee.getAddress());
		departmentRepository.save(employee.getDepartment());
		employee.getProjects().forEach(project -> projectRepository.save(project));
		return employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public Employee update(Employee employee) {
		addressRepository.save(employee.getAddress());
		departmentRepository.save(employee.getDepartment());
		employee.getProjects().forEach(project -> projectRepository.save(project));
		return employeeRepository.save(employee);
	}

	@Override
	@Transactional
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
		if (!optional.isPresent()) {
			throw new EmployeNotFoundException("Employee Not found with the given emaployee Id : "+eid);
		}
		return optional.get();
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> findAllWithPaging(Integer pageNumber, Integer numOfRecords) {
		Pageable pageable = PageRequest.of(pageNumber, numOfRecords);
		return employeeRepository.findAll(pageable).getContent();
	}

}
