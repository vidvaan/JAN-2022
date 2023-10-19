package com.ciq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciq.entity.Department;
import com.ciq.entity.Project;
import com.ciq.repository.ProjectRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project save(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project update(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public void deleteById(Long pid) {
		projectRepository.deleteById(pid);
	}

	@Override
	public Project findById(Long pid) {
		Optional<Project> optional = projectRepository.findById(pid);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Project> findAll() {
		return projectRepository.findAll();
	}

}
