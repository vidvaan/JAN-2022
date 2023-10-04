package com.ciq.service;

import java.util.List;

import com.ciq.enitity.Product;

public interface ProductService {
	
	Product save(Product product);
	
	Product update(Product product);
	
	Product findById(Integer pid);
	
	List<Product> findAll();
	
	void deleteById(Integer pid);

}
