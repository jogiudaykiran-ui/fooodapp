package com.user.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	
	private static Connection con;

	public static Connection connect() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp", "root", "Pavan@2002");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
