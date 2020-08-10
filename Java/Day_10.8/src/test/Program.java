package test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import pojo.Book;
import utils.DBUtils;

public class Program
{
	public static void main(String[] args) 
	{
		try(BookDao dao = new BookDao();)
		{
			//Book book = new Book(1026,"OS","ABC","XYZ",550);
			//dao.insert( book );
			
			//dao.update(1026, 575.50f);
			//dao.delete( 1026 );
			
			List<Book> BookList = dao.getBooks( );
			for (Book book : BookList) 
			{
				System.out.println(book.toString());
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
