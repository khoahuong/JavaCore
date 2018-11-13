/**
 *
 * Copyright (C) 2018 Luvina JSC
 * ConnectDB.java Nov 12, 2018 Mai Khoa Huong
 */
package com.luvina.bai2;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

/**
 * Xây dựng Class để tạo kết nối và đóng kết nối đến database để có thể thực
 * hiện nhiểu lần.
 * 
 * @author: Huong Mai Khoa
 *
 */
public class ConnectDB {
	private static String DB_URL = "jdbc:mysql://localhost:3306/cds";
	private static String USER_NAME = "root";
	private static String PASSWORD = "";
	protected Connection conn = null;

	/**
	 * Tạo kết nối đến database.
	 * 
	 * @return conn
	 */
	public Connection connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Hệ thống đang có lỗi.");
			// TODO: handle exception
		}
		return conn;
	}

	/**
	 * Đóng kết nối đến database.
	 */
	public void closeDB() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
