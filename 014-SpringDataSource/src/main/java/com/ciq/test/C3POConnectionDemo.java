package com.ciq.test;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class C3POConnectionDemo {
	
	public static void main(String[] args) throws PropertyVetoException, NamingException, SQLException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost/ciq");
		cpds.setUser("root");
		cpds.setPassword("root");
		   
		 
//		  DataSource ds = (DataSource) dataSource;
		  
		  System.out.println(cpds.getConnection());
		  
		
	}

}
