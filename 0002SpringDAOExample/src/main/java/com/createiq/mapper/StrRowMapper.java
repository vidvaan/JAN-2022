package com.createiq.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StrRowMapper implements RowMapper<String>{

	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getInt("EID")+" - "+rs.getString("ENAME")+" - "+rs.getDouble("ESAL");
	}

}
