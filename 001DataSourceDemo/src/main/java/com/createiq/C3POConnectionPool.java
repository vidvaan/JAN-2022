package com.createiq;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3POConnectionPool {
	public static void main(String[] args) {

		ComboPooledDataSource ds = new ComboPooledDataSource();
		
		
		try {
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/emedico");
			ds.setDriverClass("com.mysql.cj.jdbc.Driver");
			ds.setUser("root");
			ds.setPassword("root");
			System.out.println(ds.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
