package com.softserver.todolist.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtill {
	private static Connection conn = createConnaction();

	private static Connection createConnaction() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql7234875",
					"root", "19840310");
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return conn;
	}
	
	public static Connection getDBConnection() {
		return conn;
	}
	
}
