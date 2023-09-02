package com.ciq.test;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;


public class HikariConnectionDemo {
	
	public static void main(String[] args) throws PropertyVetoException, NamingException, SQLException {
		HikariDataSource cpds = new HikariDataSource();
		cpds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost/ciq");
		cpds.setUsername("root");
		cpds.setPassword("root");
		   
		 
//		  DataSource ds = (DataSource) dataSource;
		  
		  System.out.println(cpds.getConnection());
		  
		
	}

}
