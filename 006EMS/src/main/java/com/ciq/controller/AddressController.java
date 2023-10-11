package com.ciq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.entity.Address;
import com.ciq.entity.Department;
import com.ciq.service.AddressService;
import com.ciq.service.DepartmentService;

@RestController
@RequestMapping("/addr")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/findAll")
	public List<Address> findAll() {
		return addressService.findAll();
	}

	@GetMapping("/findById/{aid}")
	public Address findById(@PathVariable Long aid) {
		return addressService.findById(aid);
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Address address) {
		Address addr = null;
		try {
		    addr = addressService.save(address);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Address>(addr, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public Address update(@RequestBody Address address) {
		return addressService.update(address);
	}

	@DeleteMapping("/delete/{aid}")
	public String delete(@PathVariable Long aid) {
		addressService.deleteById(aid);
		return "Deleted Successfully";
	}

}
