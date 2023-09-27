package com.ciq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.ciq.model.Employee;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(Employee employee) {
		jdbcTemplate.update("INSERT INTO EMP_TAB VALUES(?,?,?)", new Object[] {employee.getEid(),employee.getEname(),employee.getEsal()});
		
	}

	@Override
	public void update(Employee employee) {
		jdbcTemplate.update("UPDATE EMP_TAB SET ENAME  = ? , ESAL = ? WHERE EID = ?", new Object[] {employee.getEname(),employee.getEsal(),employee.getEid()});
		
	}

	@Override
	public void deleteById(Integer eid) {
		jdbcTemplate.update("DELETE FROM EMP_TAB WHERE EID = ?", new Object[] {eid});
		
	}

	@Override
	public Employee findById(Integer eid) {
		return jdbcTemplate.queryForObject("SELECT * FROM EMP_TAB WHERE EID = ?" , new BeanPropertyRowMapper<>(Employee.class), new Object[] {eid});
	}


	
	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query("SELECT * FROM EMP_TAB", new  ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> employees = new ArrayList<>();
				while(rs.next()) {
					Employee employee  = new Employee();
					employee.setEid(rs.getInt("eid"));
					employee.setEname(rs.getString("ename"));
					employee.setEsal(rs.getDouble("esal"));
					employees.add(employee);
				}
				
				return employees;
			}
		});
	}
	

}
