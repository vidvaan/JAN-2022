package com.ciq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciq.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
