package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import utils.DBUtils;

public class Program 
{
	public static void main(String[] args) 
	{
		String sql = "INSERT INTO BookTable VALUES(?,?,?,?,?)";
		try( Connection connection = DBUtils.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);)
		{
			statement.setInt(1, 1026);
			statement.setString(2, "OS");
			statement.setString(3, "OS Concept's");
			statement.setString(4, "Galivin");
			statement.setFloat(5, 550);
			int count = statement.executeUpdate( );
			System.out.println(count+" record(s) updated");
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
	
}
