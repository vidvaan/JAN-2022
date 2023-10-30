package com.ciq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
		
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		System.out.println(bc.encode("srikanth"));
	}

}
