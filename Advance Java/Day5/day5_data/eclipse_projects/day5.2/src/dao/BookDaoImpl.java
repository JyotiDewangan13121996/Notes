package dao;

import java.util.ArrayList;
import java.util.List;

import pojos.Book;

import java.sql.*;
import static utils.DBUtils.getConnection;

public class BookDaoImpl implements IBookDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3;

	public BookDaoImpl() throws Exception {
		// get cn
		cn = getConnection();
		pst1 = cn.prepareStatement("select distinct category from dac_books");
		pst2 = cn.prepareStatement("select * from dac_books where category=?");
		pst3 = cn.prepareStatement("select * from dac_books where id=?");
		System.out.println("book dao created...");
	}

	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (cn != null)
			cn.close();
		System.out.println("book dao cleaned up");
	}

	@Override
	public List<String> getAllCategories() throws Exception {
		List<String> cats = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				cats.add(rst.getString(1));
		}
		System.out.println("dao : " + cats);
		return cats;
	}

	@Override
	public List<Book> getBooksByCategory(String categoryName) throws Exception {
		// set IN param
		pst2.setString(1, categoryName);
		List<Book> books = new ArrayList<>();
		try (ResultSet rst = pst2.executeQuery()) {
			while (rst.next())
				books.add(new Book(rst.getInt(1), rst.getString(2), rst.getString(3), categoryName, rst.getDouble(5)));
		}
		System.out.println("dao rets : " + books);
		return books;
	}

	@Override
	public Book getBookDetails(int id) throws Exception {
		// set In param
		pst3.setInt(1, id);
		try (ResultSet rst = pst3.executeQuery()) {
			if (rst.next())
				return new Book(id, rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5));
		}
		return null;
	}

}
