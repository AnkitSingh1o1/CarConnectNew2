package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.exception.DatabaseConnectionException;

public class DBConnection {
	/* Step 1: create connection variables */ 
	static String userDB="root" ;
	static String passDB="Redblue@786";
	static String url="jdbc:mysql://localhost:3306/mydb"; 
	static String driver="com.mysql.cj.jdbc.Driver";
	static Connection con;
	
	public static Connection dbConnect() throws DatabaseConnectionException {
		/* Step 2: load the driver */
		try {
			Class.forName(driver);
			//System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) {
			throw new DatabaseConnectionException("Driver not loaded...");
		}
		
		/* Step 3: Establish the connection */ 
		try {
			con = DriverManager.getConnection(url, userDB, passDB);
			//System.out.println("connection established");
		} catch (SQLException e) {
			throw new DatabaseConnectionException("connection failed");
		}
		return con;
	}
	
	
	public static void dbClose() throws DatabaseConnectionException {
		try {
			con.close ();
			//System.out.println("Connection closed ");
		} catch (SQLException e) {
			throw new DatabaseConnectionException("Connection could not be closed");
		}
	}
	
//	public static void main(String[] args) {
//		DBConnection.dbConnect();
//		DBConnection.dbClose();
//	}

}
