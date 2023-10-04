package com.ciq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.enitity.Product;
import com.ciq.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Product product){
		Product productSave = productService.save(product);
		return new ResponseEntity<Product>(productSave, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Product product){
		Product productSave = productService.update(product);
		return new ResponseEntity<Product>(productSave, HttpStatus.OK);
	}
	
	
	@GetMapping("/{pid}")
	public ResponseEntity<?> findById(@PathVariable Integer pid){
		Product product = productService.findById(pid);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return new ResponseEntity<List<Product>>(productService.findAll(), HttpStatus.OK);
	}
	
	
	

}
