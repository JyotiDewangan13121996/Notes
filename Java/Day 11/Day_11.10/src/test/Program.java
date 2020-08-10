package test;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.DBUtils;

public class Program 
{
	public static void main(String[] args) 
	{
		Connection connection = null;
		try
		{
			connection = DBUtils.getConnection();
			DatabaseMetaData dm = connection.getMetaData();
			System.out.println(dm.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)); //false
			System.out.println(dm.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)); //true
			System.out.println(dm.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)); //false
			
			System.out.println(dm.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY));//true
			System.out.println(dm.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE));//true
			System.out.println(dm.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));//true
			System.out.println(dm.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE));//true
			System.out.println(dm.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY));//false
			System.out.println(dm.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE));//false
			
			System.out.println(dm.supportsResultSetHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT));//false
			System.out.println(dm.supportsResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT));//true
			
			
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
		finally 
		{
			try
			{
				connection.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
}
