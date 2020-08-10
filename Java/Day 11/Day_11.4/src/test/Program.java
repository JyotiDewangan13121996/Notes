package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.DBUtils;

public class Program 
{
	public static void main(String[] args) 
	{
		String sql = "SELECT * FROM users where email= ? and password=?";
		try( Connection connection = DBUtils.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);)
		{
			String email = "sandeepkulange@gmail.com";
			String password = "sandeep";
			statement.setString(1, email);
			statement.setString(2, password);
			try( ResultSet rs = statement.executeQuery();)
			{
				if( rs.next())
				{
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				}
			}
			System.out.println("abc");
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
	
}
