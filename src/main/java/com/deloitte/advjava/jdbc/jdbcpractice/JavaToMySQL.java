package com.deloitte.advjava.jdbc.jdbcpractice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaToMySQL {
	public static void main(String[] args) throws SQLException {
		Connection con = null;

		try {
			// 1. Register driver class
			// Class.forName("com.mysql.jdbc.Driver");
			// 2. Create Connection Object
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			System.out.println("Database Metadata");
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("update employee set salary=salary-? where id=?");
			
			pstmt.setInt(1,500000);
			pstmt.setInt(2,103);
			pstmt.execute();
			System.out.println("500000 is deduced from Manga account");
			//int i=100/0;
			pstmt = con.prepareStatement("update employee set salary=salary+? where id=?");
			pstmt.setInt(1,500000);
			pstmt.setInt(2,105);
			pstmt.execute();
			System.out.println("50,000 is credite to Dhoni account");
			/*
			 * DatabaseMetaData dbmd = con.getMetaData();
			 * System.out.println(dbmd.getDatabaseMajorVersion());
			 * System.out.println(dbmd.getDatabaseProductName());
			 * System.out.println(dbmd.getURL()); System.out.println(dbmd.getUserName());
			 */
			// 3. Create Statement Object
			// stmt=con.createStatement();
			/*
			 * CallableStatement cstmt = con.prepareCall("{call INSERTR(?,?,?)}");
			 * cstmt.setInt(1, 107); cstmt.setString(2, "Pandey"); cstmt.setInt(3,5555454);
			 * cstmt.execute();
			 * System.out.println("Stroed procedured called and executed successfully");
			 */
			
			// 4. Execute SQL queries
			/*
			 * PreparedStatement pstmt =
			 * con.prepareStatement("select * from  employee  where id=?"); pstmt.setInt(1,
			 * 105);
			 */
			// int count = pstmt.executeUpdate();
			// int count = stmt.executeUpdate("insert into employee
			// values(105,'Dhoni',90000)");
			// int count = stmt.executeUpdate("update employee set salary=100000 where
			// id=105");
			// int count = stmt.executeUpdate("delete from employee where id=105");

			//System.out.println(count + "(s) record updateed");
			/*
			 * ResultSet rs = pstmt.executeQuery();
			 * System.out.println("Resultset metadata"); ResultSetMetaData rsmd =
			 * rs.getMetaData(); System.out.println(rsmd.getColumnCount());
			 * System.out.println(rsmd.getColumnClassName(1));
			 * System.out.println(rsmd.getColumnTypeName(1));
			 */
			
			/*
			 * while (rs.next()) { System.out.println(rs.getInt(1) + " " + rs.getString(2) +
			 * " " + rs.getInt(3)); }
			 */
			con.commit(); 
		} catch (SQLException e) {
			con.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// stmt.close();
			// 5. close connection
			con.close();
		}

	}

}
