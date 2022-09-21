package com.createiq.daoTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/spring.xml")
public class JdbcTemplateTest {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void jdbcTemplateTest() {
		assertNotNull(jdbcTemplate);
	}
}
