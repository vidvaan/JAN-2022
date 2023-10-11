package com.ciq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ciq.entity.Department;
import com.ciq.entity.Employee;
import com.ciq.repository.DepartmentRepository;

public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department save(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department update(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public void deleteById(Long did) {
       departmentRepository.deleteById(did);		
	}

	@Override
	public Department findById(Long did) {
		Optional<Department> optional = departmentRepository.findById(did);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}


}
