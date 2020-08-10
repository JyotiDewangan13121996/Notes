package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Book;
import utils.DBUtils;

public class BookDao implements Closeable
{
	private Connection connection;
	private CallableStatement insertStatement;
	private CallableStatement updateStatement;
	private CallableStatement deleteStatement;
	private CallableStatement selectStatement;
	public BookDao()throws Exception
	{
		this.connection = DBUtils.getConnection();
		this.insertStatement = connection.prepareCall("{call sp_insert_book(?,?,?,?,?)}");
		this.updateStatement = connection.prepareCall("{call sp_update_book(?,?)}");
		this.deleteStatement = connection.prepareCall("{call sp_delete_book(?)}");
		this.selectStatement = connection.prepareCall("{call sp_select_book()}");
	}
	public boolean insert(Book book)throws Exception
	{
		this.insertStatement.setInt(1, book.getBookId());
		this.insertStatement.setString(2, book.getSubjectName());
		this.insertStatement.setString(3, book.getBookName());
		this.insertStatement.setString(4, book.getAuthorName());
		this.insertStatement.setFloat(5, book.getPrice());
		return this.insertStatement.execute();
	}
	public boolean update(int bookId, float price)throws Exception
	{
		this.updateStatement.setInt(1, bookId);
		this.updateStatement.setFloat(2, price);
		return this.updateStatement.execute();
	}
	public boolean delete(int bookId) throws Exception
	{
		this.deleteStatement.setInt(1, bookId);
		return this.deleteStatement.execute();
	}
	public List<Book> getBooks()throws Exception
	{
		List<Book> bookList = new ArrayList<Book>();
		this.selectStatement.execute();
		try( ResultSet rs = this.selectStatement.getResultSet())
		{
			while( rs.next())
			{
				Book book = new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5));
				bookList.add(book);
			}
		}
		return bookList;
	}
	@Override
	public void close() throws IOException 
	{
		try
		{
			this.insertStatement.close();
			this.updateStatement.close();
			this.deleteStatement.close();
			this.selectStatement.close();
			this.connection.close();
		}
		catch( SQLException cause )
		{
			throw new IOException(cause);
		}
	}
	
}
