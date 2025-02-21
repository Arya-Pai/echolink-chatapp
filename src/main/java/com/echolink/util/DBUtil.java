package com.echolink.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String JDBC_URl="dbc:mysql://localhost:3306/echolink_db";
	 private static final String JDBC_USERNAME = "root";
	 private static final String JDBC_PASSWORD = "bigchill@8459";
	 
	 public static Connection getConnection() throws ClassNotFoundException,SQLException{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 return DriverManager.getConnection(JDBC_URl,JDBC_USERNAME,JDBC_PASSWORD);
	 }
	 
}
