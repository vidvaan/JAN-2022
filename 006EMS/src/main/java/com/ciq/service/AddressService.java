package com.ciq.service;

import java.util.List;

import com.ciq.entity.Address;

public interface AddressService {
	public Address save(Address address);

	public Address update(Address address);

	public void deleteById(Long did);

	public Address findById(Long did);

	public List<Address> findAll();
}
