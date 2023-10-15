package com.ciq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciq.entity.Address;
import com.ciq.entity.Project;
import com.ciq.repository.AddressRepository;
@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address update(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public void deleteById(Long aid) {
         addressRepository.deleteById(aid);
	}

	@Override
	public Address findById(Long aid) {
		Optional<Address> optional = addressRepository.findById(aid);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Address> findAll() {
		return null;
	}

}
