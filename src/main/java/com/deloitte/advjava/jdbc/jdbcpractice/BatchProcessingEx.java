package com.deloitte.advjava.jdbc.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchProcessingEx {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		System.out.println("Database Metadata");
		PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?)");
		pstmt.setInt(1, 108);
		pstmt.setString(2, "sachin");
		pstmt.setInt(3, 445554);
		pstmt.addBatch();
		pstmt.setInt(1, 109);
		pstmt.setString(2, "sehwag");
		pstmt.setInt(3, 4555);
		pstmt.addBatch();
		pstmt.setInt(1, 110);
		pstmt.setString(2, "Ganguly");
		pstmt.setInt(3, 433443);
		pstmt.addBatch();
		
		int[] records = pstmt.executeBatch();
		System.out.println(records.length+" record(s) inserted");
		

	}

}
