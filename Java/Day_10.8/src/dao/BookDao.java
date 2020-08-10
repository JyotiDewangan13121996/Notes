package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Book;
import utils.DBUtils;

public class BookDao implements Closeable 
{
	private Connection connection;
	private Statement statement;
	public BookDao() throws Exception 
	{
		this.connection = DBUtils.getConnection();
		this.statement = this.connection.createStatement();
	}
	public int insert(Book book) throws Exception 
	{
		String sql = "INSERT INTO BookTable VALUES("+book.getBookId()+",'"+book.getSubjectName()+"','"+book.getBookName()+"', '"+book.getAuthorName()+"',"+book.getPrice()+")";
		return this.statement.executeUpdate(sql);
	}
	public int update(int bookId, float price)throws Exception
	{
		String sql = "UPDATE BookTable SET price="+price+" WHERE book_id="+bookId+"";
		return this.statement.executeUpdate(sql);
	}
	public int delete(int bookId)throws Exception
	{
		String sql = "DELETE FROM BookTable WHERE book_id="+bookId+"";
		return this.statement.executeUpdate(sql);
	}
	public List<Book> getBooks()throws Exception
	{
		List<Book> bookList = new ArrayList<Book>();
		String sql = "SELECT * FROM BookTable";
		try( ResultSet rs = this.statement.executeQuery(sql);)
		{
			while( rs.next())
			{
				Book book = new Book();
				book.setBookId( rs.getInt("book_id"));
				book.setSubjectName( rs.getString("subject_name") );
				book.setBookName( rs.getString("book_name") );
				book.setAuthorName( rs.getString("author_name") );
				book.setPrice( rs.getFloat("price") );
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
			if( this.statement != null )
				this.statement.close();
			if( this.connection != null )
				this.connection.close();
		}
		catch (SQLException cause ) 
		{
			throw new IOException( cause );
		}
	}
	
	
}
