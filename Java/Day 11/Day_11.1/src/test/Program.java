package test;

import java.sql.Connection;
import java.sql.Statement;

import utils.DBUtils;

public class Program 
{
	public static void main(String[] args) 
	{
		try( Connection connection = DBUtils.getConnection();
			Statement statement = connection.createStatement();)
		{
			String sql = "INSERT INTO BookTable VALUES(1026,'OS','OS Concept's','Galvin',500)";
			int count = statement.executeUpdate(sql);
			System.out.println(count+" record(s) updated");
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
	
}
