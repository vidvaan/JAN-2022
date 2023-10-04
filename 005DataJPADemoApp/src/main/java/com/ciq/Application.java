package com.ciq;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ciq.enitity.Product;
import com.ciq.repository.ProductRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Product product1 =  new Product();
		product1.setPname("TV");
		product1.setPcost(20000.00);
		product1.setMfd(new Date());
		
		Product product2 =  new Product();
		product2.setPname("Mobile");
		product2.setPcost(20000.00);
		product2.setMfd(new Date());
		
		
		productRepository.save(product1);
		productRepository.save(product2);
		
		
	}
	
	

}
