package com.createiq.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcCall {
	
	public static void main(String[] args) {
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "root");
		    callableStatement = connection.prepareCall("{CALL ADDITION(?,?,?)}");
		    callableStatement.setInt(1, 20);
		    callableStatement.setInt(2, 30);
		    callableStatement.registerOutParameter(3, Types.INTEGER);
		    callableStatement.execute();
		    int result = callableStatement.getInt(3);
		    System.out.println("Result = "+result);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				callableStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}

}
