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
		try( Connection connection = DBUtils.getConnection();
			Statement statement = connection.createStatement(); )
		{
			String sql = "SELECT * FROM BookTable";
			try( ResultSet rs =  statement.executeQuery(sql); )
			{
				while( rs.next() )
				{
					Book book = new Book( rs.getInt("book_id"),rs.getString("subject_name"), rs.getString("book_name"),  rs.getString("author_name"), rs.getFloat("price") );
					System.out.println(book.toString());
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
