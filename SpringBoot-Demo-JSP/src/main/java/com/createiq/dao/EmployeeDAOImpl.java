package com.createiq.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.createiq.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(Employee employee) {
		jdbcTemplate.update("INSERT INTO EMP_TAB VALUES(?,?,?)", new Object[] {employee.getEid(),employee.getEname(),employee.getEsal()});
		
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int eid) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query("SELECT * FROM EMP_TAB", new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

}
