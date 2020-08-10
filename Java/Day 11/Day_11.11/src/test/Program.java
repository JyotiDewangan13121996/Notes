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
		Statement statement = null;
		try
		{
			connection = DBUtils.getConnection();
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM BookTable";
			try( ResultSet rs =  statement.executeQuery(sql); )
			{
				rs.next();
				rs.next();
				rs.next();
				/*if( rs.absolute(10) )
					Program.printRow(rs);*/
				/*if( rs.relative(10))
					Program.printRow(rs);*/
				
				rs.afterLast();
				if( rs.relative(-3))
					Program.printRow(rs);
			}
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
	public static void main3(String[] args) 
	{
		Connection connection = null;
		Statement statement = null;
		try
		{
			connection = DBUtils.getConnection();
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM BookTable";
			try( ResultSet rs =  statement.executeQuery(sql); )
			{
				rs.afterLast();
				if( rs.isAfterLast())
				{
					while( rs.previous() )
						Program.printRow( rs );
				}
				System.out.println("********");
				rs.afterLast();
				if( rs.isAfterLast())
				{
					while( rs.previous() )
						Program.printRow( rs );
				}
			}
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
	public static void main2(String[] args) 
	{
		Connection connection = null;
		Statement statement = null;
		try
		{
			connection = DBUtils.getConnection();
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM BookTable";
			try( ResultSet rs =  statement.executeQuery(sql); )
			{
				if( rs.isBeforeFirst())
				{
					while( rs.next() )
						Program.printRow( rs );
				}
				System.out.println("********");
				rs.beforeFirst();
				if( rs.isBeforeFirst())
				{
					while( rs.next() )
						Program.printRow( rs );
				}	
			}
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
	public static void main1(String[] args) 
	{
		Connection connection = null;
		Statement statement = null;
		try
		{
			connection = DBUtils.getConnection();
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM BookTable";
			try( ResultSet rs =  statement.executeQuery(sql); )
			{
				if( rs.isBeforeFirst())
				{
					while( rs.next() )
						Program.printRow( rs );
				}
				System.out.println("********");
				if( rs.isAfterLast())
				{
					while( rs.previous())
						Program.printRow(rs);
				}
				System.out.println("********");
				if( rs.first())
					Program.printRow(rs);
				if( rs.last())
					Program.printRow(rs);
				System.out.println("********");
					
			}
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
	private static void printRow(ResultSet rs)throws Exception 
	{
		if( rs != null )
			System.out.printf("%-5d%-15s%-60s%-30s%-10.2f\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5));
		
	}
}
