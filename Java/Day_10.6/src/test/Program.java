package test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Book;
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
			statement = connection.createStatement();
			String sql = "SELECT * FROM BookTable";
			try( ResultSet rs =  statement.executeQuery(sql); )
			{
				while( rs.next() )
				{
					Book book = new Book();
					book.setBookId( rs.getInt("book_id"));
					book.setSubjectName( rs.getString("subject_name") );
					book.setBookName( rs.getString("book_name") );
					book.setAuthorName( rs.getString("author_name") );
					book.setPrice( rs.getFloat("price") );
					System.out.println(book.toString());
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if( statement != null )
					statement.close();
				if( connection != null )
					connection.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
