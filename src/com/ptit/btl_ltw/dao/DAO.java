package com.ptit.btl_ltw.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	public static Connection con;

	public DAO() {
		if (con == null) {
			String dbUrl = "jdbc:mysql://localhost:3306/data_ltw";
			String dbClass = "com.mysql.cj.jdbc.Driver";

			try {
				Class.forName(dbClass);
				con = DriverManager.getConnection(dbUrl, "root", "root");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

//	public static Connection getConnection() {
//		Connection conn = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_ltw", "root", "thanhthanh1996");
//			System.out.println("connect successfully!");
//		} catch (Exception ex) {
//			System.out.println("connect failure!");
//			ex.printStackTrace();
//		}
//		return conn;
//	}
}
