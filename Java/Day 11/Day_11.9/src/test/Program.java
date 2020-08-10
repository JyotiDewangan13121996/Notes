package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import utils.DBUtils;

public class Program 
{
	public static void main(String[] args) 
	{
		Connection connection = null;
		Statement statement = null;
		try
		{
			connection = DBUtils.getConnection();
			statement =connection.createStatement();
			connection.setAutoCommit(false);
			
			String sql = "UPDATE accounts SET balance=balance - 5000 WHERE acc_number=101";
			statement.executeUpdate(sql);
			
			sql = "UPDATE accounts SET balance=balance + 5000 WHERE acc_number=102";
			statement.executeUpdate(sql);
			
			connection.commit();
			System.out.println("Fund transferd..");
		}
		catch( Exception ex )
		{
			try 
			{
				connection.rollback();
				ex.printStackTrace();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		finally 
		{
			try
			{
				statement.close();
				connection.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
}
