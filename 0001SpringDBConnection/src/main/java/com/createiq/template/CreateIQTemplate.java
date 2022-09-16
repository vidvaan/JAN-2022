package com.createiq.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class CreateIQTemplate {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int update(String sql, Object[] values) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < values.length; i++) {
				ps.setObject(i + 1, values[i]);
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;

	}

}
