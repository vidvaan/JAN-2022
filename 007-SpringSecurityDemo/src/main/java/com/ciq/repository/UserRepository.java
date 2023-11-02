package com.ciq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciq.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
