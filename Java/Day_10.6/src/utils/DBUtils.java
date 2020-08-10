package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils 
{
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/dac_db";
	public static final String USER = "root";
	public static final String PASSWORD = "mysql@8017";
	public static Connection getConnection()throws Exception
	{
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
