package test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class Program
{
	public static void main(String[] args) 
	{
		try( Connection connection = DBUtils.getConnection();
			Statement statement = connection.createStatement(); )
		{
			String email= "sandeepkulange@gmail.com' or '1'='1";
			String password = "";
			String sql = "SELECT * FROM users where email='"+email+"' and password='"+password+"'";
			try( ResultSet rs =  statement.executeQuery(sql); )
			{
				if( rs.next() )
				{
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
