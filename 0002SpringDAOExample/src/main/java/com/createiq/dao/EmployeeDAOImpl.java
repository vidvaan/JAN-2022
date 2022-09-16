package com.createiq.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.createiq.mapper.EmployeeRowMapper;
import com.createiq.mapper.StrRowMapper;
import com.createiq.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	
	

	public void save(Employee employee) {
		// jdbcTemplate.update("INSERT INTO EMPLOYEE VALUES(?,?,?)",
		// new Object[] { employee.getEid(), employee.getEname(), employee.getEsal() });

		jdbcTemplate.execute("INSERT INTO EMPLOYEE VALUES(?,?,?)", new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, employee.getEid());
				ps.setString(2, employee.getEname());
				ps.setDouble(3, employee.getEsal());
				return ps.executeUpdate();
			}
		});
	}

	public void update(Employee employee) {
		jdbcTemplate.update("UPDATE EMPLOYEE SET ENAME = ? ,ESAL = ? WHERE EID = ?",
				new Object[] { employee.getEname(), employee.getEsal(), employee.getEid() });
	}

	public void delete(int eid) {
		jdbcTemplate.update("DELETE FROM EMPLOYEE WHERE EID = ?", new Object[] { eid });
	}

	public List<Employee> findAll() {
		// return jdbcTemplate.query("SELECT * FROM EMPLOYEE", new
		// BeanPropertyRowMapper(Employee.class));

		return jdbcTemplate.query("SELECT * FROM EMPLOYEE", new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Employee> employees = new ArrayList<Employee>();

				while (rs.next()) {
					Employee employee = new Employee();
					employee.setEid(rs.getInt("EID"));
					employee.setEname(rs.getString("ENAME"));
					employee.setEsal(rs.getDouble("ESAL"));
					employees.add(employee);
				}

				return employees;
			}

		});
	}

	public Employee findById(Integer eid) {
		return (Employee) jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEE WHERE EID = ?", new Object[] { eid },
				new BeanPropertyRowMapper(Employee.class));
	}

	// public List<String> findAllDataStr() {
	// return jdbcTemplate.query("SELECT * FROM EMPLOYEE" , new RowMapper<String>()
	// {
	//
	// @Override
	// public String mapRow(ResultSet rs, int rowNum) throws SQLException {
	// return rs.getInt("EID")+" - "+rs.getString("ENAME")+" -
	// "+rs.getDouble("ESAL");
	// }
	// });
	// }

	public List<String> findAllDataStr() {
		return jdbcTemplate.query("SELECT * FROM EMPLOYEE",
				(rs, rn) -> rs.getInt("EID") + " - " + rs.getString("ENAME") + " - " + rs.getDouble("ESAL"));
	}

	// SELECT * FROM EMPLOYEE where ename = ? and esal = ?
	// jdbcTemplate.query("SELECT * FROM EMPLOYEE where ename = ? and esal = ?",new
	// Object[] {ename,esal}, new BeanPropertyRowMapper(Employee.class));

	public Integer callStoredProc(Integer num1, Integer num2) {

		return jdbcTemplate.execute("{CALL ADDITION(?,?,?)}", new CallableStatementCallback<Integer>() {

			@Override
			public Integer doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
				cs.setInt(1, num1);
				cs.setInt(2, num2);
				cs.registerOutParameter(3, Types.INTEGER);
				cs.execute();
				int result = cs.getInt(3);
				return result;
			}
		});

	}

}
