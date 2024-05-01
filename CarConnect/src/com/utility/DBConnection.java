package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.exception.DatabaseConnectionException;

public class DBConnection {
	static String userDB = "root";
	static String passDB = "";
	static String url = "jdbc:mysql://localhost:3306/car_connect";
	static String driver = "com.mysql.jdbc.Driver";
	static Connection con;

	public static Connection dbConnect() throws DatabaseConnectionException {
		try {
			Class.forName(driver);
//			System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) {
			throw new DatabaseConnectionException("Driver not loaded...");
		}

		try {
			con = DriverManager.getConnection(url, userDB, passDB);
//			System.out.println("Driver established");
		} catch (SQLException e) {
			throw new DatabaseConnectionException("Connection failed...");
		}
		return con;
	}

	public static void dbClose() throws DatabaseConnectionException {
		try {
			con.close();
//			System.out.println("Driver closed");
		} catch (SQLException e) {
			throw new DatabaseConnectionException("Connection not closed...");
		}
	}

}
