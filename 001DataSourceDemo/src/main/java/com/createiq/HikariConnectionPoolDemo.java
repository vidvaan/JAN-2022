package com.createiq;

import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class HikariConnectionPoolDemo {
	
	public static void main(String[] args) {
		HikariDataSource hd = new HikariDataSource();
		hd.setJdbcUrl("jdbc:mysql://localhost:3306/emedico");
		hd.setUsername("root");
		hd.setPassword("root");
		hd.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		try {
			System.out.println(hd.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
