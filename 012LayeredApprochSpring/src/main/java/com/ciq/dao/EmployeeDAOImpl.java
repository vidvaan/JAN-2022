package com.ciq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ciq.model.Employee;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	private DataSource dataSource;

	@Override
	public void save(Employee employee) {	
		System.out.println("Employee DAO 1 Save Called: "+employee);
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			 connection = dataSource.getConnection();
			 ps = connection.prepareStatement("INSERT INTO EMP_TAB VALUES(?,?,?)");
			 ps.setInt(1, employee.getEid());
			 ps.setString(2, employee.getEname());
			 ps.setDouble(3, employee.getEsal());
			 ps.executeUpdate();
			System.out.println("Success!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
