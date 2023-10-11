package com.ciq.service;

import java.util.List;

import com.ciq.entity.Department;

public interface DepartmentService {
	public Department save(Department department);

	public Department update(Department department);

	public void deleteById(Long did);

	public Department findById(Long did);

	public List<Department> findAll();
}
