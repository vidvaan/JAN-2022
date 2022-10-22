package com.createiq.dao;

import java.sql.Types;
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
		jdbcTemplate.update("INSERT INTO EMPLOYEE VALUES(?,?,?)",
				new Object[] { employee.getEid(), employee.getEname(), employee.getEsal() });

	}

	@Override
	public void update(Employee employee) {
		jdbcTemplate.update("UPDATE EMPLOYEE SET ENAME =? , ESAL =? WHERE EID = ?",
				new Object[] { employee.getEname(), employee.getEsal(), employee.getEid() });
	}

	@Override
	public void delete(int eid) {
		jdbcTemplate.update("DELETE FROM EMPLOYEE WHERE EID = ?", new Object[] { eid });
	}

	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query("SELECT * FROM EMPLOYEE", new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public Employee findById(Integer eid) {
		// return jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEE WHERE EID= ?",new
		// BeanPropertyRowMapper<Employee>(Employee.class),eid);

		return jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEE WHERE EID= ?", new Object[] { eid },
				new int[] { Types.INTEGER }, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

}
