package dao;

import java.io.Closeable;
import java.io.IOException;
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
	private PreparedStatement insertStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement deleteStatement;
	private PreparedStatement selectStatement;
	public BookDao()throws Exception
	{
		this.connection = DBUtils.getConnection();
		this.insertStatement = connection.prepareStatement("INSERT INTO BookTable VALUES(?,?,?,?,?)");
		this.updateStatement = connection.prepareStatement("UPDATE BookTable SET price=? WHERE book_id=?");
		this.deleteStatement = connection.prepareStatement("DELETE FROM BookTable WHERE book_id=?");
		this.selectStatement = connection.prepareStatement("SELECT * FROM BookTable");
	}
	public int insert(Book book)throws Exception
	{
		this.insertStatement.setInt(1, book.getBookId());
		this.insertStatement.setString(2, book.getSubjectName());
		this.insertStatement.setString(3, book.getBookName());
		this.insertStatement.setString(4, book.getAuthorName());
		this.insertStatement.setFloat(5, book.getPrice());
		return this.insertStatement.executeUpdate();
	}
	public int update(int bookId, float price)throws Exception
	{
		this.updateStatement.setFloat(1, price);
		this.updateStatement.setInt(2, bookId);
		return this.updateStatement.executeUpdate();
	}
	public int delete(int bookId) throws Exception
	{
		this.deleteStatement.setInt(1, bookId);
		return this.deleteStatement.executeUpdate();
	}
	public List<Book> getBooks()throws Exception
	{
		List<Book> bookList = new ArrayList<Book>();
		try( ResultSet rs = this.selectStatement.executeQuery())
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
