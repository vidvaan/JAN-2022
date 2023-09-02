package com.ciq.test;

import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class DBCPConnectionDemo {
	
	public static void main(String[] args) {
		 BasicDataSource basicDataSource = new BasicDataSource();
		 basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		 basicDataSource.setUrl("jdbc:mysql://localhost/ciq");
		 basicDataSource.setUsername("root");
		 basicDataSource.setPassword("root");
		 
		 try {
			System.out.println(basicDataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
