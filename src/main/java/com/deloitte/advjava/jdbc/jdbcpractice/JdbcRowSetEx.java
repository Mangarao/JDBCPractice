package com.deloitte.advjava.jdbc.jdbcpractice;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetEx {
	public static void main(String[] args) throws SQLException {
		JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
		jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/mydb");
		jdbcRowSet.setUsername("root");
		jdbcRowSet.setPassword("root");
		jdbcRowSet.setCommand("select * from employee");
		jdbcRowSet.execute();
		while(jdbcRowSet.next()) {
			System.out.println(jdbcRowSet.getInt(1)+" "+jdbcRowSet.getString(2)+" "+jdbcRowSet.getInt(3));
		}
	}

}
