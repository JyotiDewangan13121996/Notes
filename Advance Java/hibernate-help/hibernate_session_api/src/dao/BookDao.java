package dao;

import java.util.Date;
import java.util.List;

import pojos.Book;

public interface BookDao {
	String saveBook(Book b);
	Book getBookDetails(int id);
	List<Book>getAllBooks();
	List<Book>getBooksByDatePrice(Date d1,double price);
	List<Book> updateBooks(String author,double discount);
	Book deleteBook(int id);
	
}
