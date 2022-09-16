package com.createiq;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPConnectionDemo {
	
	public static void main(String[] args) {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/emedico");
		basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root");
		basicDataSource.setInitialSize(10);
		
		try {
			System.out.println(basicDataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
