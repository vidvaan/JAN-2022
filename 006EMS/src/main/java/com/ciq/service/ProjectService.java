package com.ciq.service;

import java.util.List;

import com.ciq.entity.Project;

public interface ProjectService {
	public Project save(Project project);

	public Project update(Project project);

	public void deleteById(Long pid);

	public Project findById(Long pid);

	public List<Project> findAll();
}
