package com.packagedelivery.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
	private static Connection connection = null;
	private static String url = "jdbc:mysql://localhost:3306/delivery_management_db";
	private static String username = "root";
	private static String password = "root";

	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Done");
		} catch (Exception e) {
			System.out.println("Connection Not Createted : " + e);
		}
		return connection;
	}
	public static void main(String[] args) {
		System.out.println(DatabaseUtil.getConnection());
	}
}
