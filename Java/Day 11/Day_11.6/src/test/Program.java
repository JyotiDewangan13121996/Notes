package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.DBUtils;

public class Program 
{
	public static void main(String[] args) 
	{
		String sql = "{call sp_insert_book(?,?,?,?,?)}";
		try( Connection connection = DBUtils.getConnection();
			CallableStatement statement = connection.prepareCall(sql))
		{
			statement.setInt(1, 1026);
			statement.setString(2, "OS");
			statement.setString(3, "OS Concepts");
			statement.setString(4, "Galvin");
			statement.setFloat(5, 550);
			boolean result = statement.execute();
			System.out.println("Status	:	"+result);
			System.out.println("Update Count	:	"+statement.getUpdateCount());
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
	public static void main1(String[] args) 
	{
		String sql = "{call sp_select_book()}";
		try( Connection connection = DBUtils.getConnection();
			CallableStatement statement = connection.prepareCall(sql))
		{
			boolean result = statement.execute();
			try( ResultSet rs = statement.getResultSet();)
			{
				while( rs.next())
				{
					int bookId = rs.getInt(1);
					String subjectName = rs.getString(2);
					String bookName = rs.getString(3);
					String authorName = rs.getString(4);
					float price = rs.getFloat(5);
					System.out.println(bookId+" "+bookName+" "+price);
				}
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
	
}
