package utils;

import java.sql.*;

public class DBUtils {
	public static Connection getConnection() throws Exception{
		String url="jdbc:mysql://localhost:3306/test_dac";
		//load JDBC driver Type IV
		Class.forName("com.mysql.cj.jdbc.Driver");
		//get cn from DM
		return DriverManager.getConnection(url,"madhura","madhura");
	}
}
