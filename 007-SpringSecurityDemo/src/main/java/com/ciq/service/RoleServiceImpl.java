package com.ciq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciq.entity.Role;
import com.ciq.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

}
