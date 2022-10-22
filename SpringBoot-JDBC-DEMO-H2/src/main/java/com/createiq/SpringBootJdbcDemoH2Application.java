package com.createiq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJdbcDemoH2Application {

	public static void main(String[] args) {
		System.out.println("test");
		SpringApplication.run(SpringBootJdbcDemoH2Application.class, args);
	}

}
