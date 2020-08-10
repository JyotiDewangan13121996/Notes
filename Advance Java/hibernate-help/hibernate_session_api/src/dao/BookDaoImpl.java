package dao;

import org.hibernate.*;
import static utils.HibernateUtils.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import pojos.Book;

public class BookDaoImpl implements BookDao {

	@Override
	public String saveBook(Book b) {
		Integer id = null;
		// session
		Session hs = getSf().openSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			id = (Integer) hs.save(b);
			/*
			 * System.out.println("Press enter to continue"); System.in.read();
			 */
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} /*
			 * catch (IOException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
		finally {
			if (hs != null)
				hs.close();
		}

		return "Book added with ID " + id;
	}

	@Override
	public Book getBookDetails(int id) {

		Book b = null;
		// session
		Session hs = getSf().openSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			b = hs.get(Book.class, id);
			b = hs.get(Book.class, id);
			b = hs.get(Book.class, id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}
		return b;

	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> l1 = null;
		String jpql = "select b from Book b";
		// get current session
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			// l1 --- list of PERSISTENT POJOs
			l1 = hs.createQuery(jpql, Book.class).getResultList();
			System.out.println(l1.getClass().getName());
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

	@Override
	public List<Book> getBooksByDatePrice(Date d1, double price1) {
		List<Book> l1 = null;
		// ret all books > price & published before specified date
		String jpql = "select b from Book b where b.price > :pr and  b.pubDate < :dt";
		// hs
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, Book.class).setParameter("pr", price1).setParameter("dt", d1).getResultList();
			// l1 : list of PERSISTENT entities
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1; // l1 : list of PERSISTENT entities
	}

	@Override
	public List<Book> updateBooks(String author1, double discount) {
		List<Book> l1 = null;
		// ret all books by author
		String jpql = "select b from Book b where b.author = :au";
		// hs
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {

			l1 = hs.createQuery(jpql, Book.class).
					setParameter("au", author1).getResultList();
			for(Book b : l1)
				b.setPrice(b.getPrice()-discount);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		for(Book b : l1)
			b.setPrice(b.getPrice()-discount);
		return l1; // l1 : list of DETACHED entities

	}

	@Override
	public Book deleteBook(int id) {
		Book b = null;
		// session
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			b = hs.get(Book.class, id); // b--- PERSISTENT / null
			if(b != null)
				hs.delete(b);//REMOVED : marked for removal
			tx.commit(); //delete query fired --deleted form db n removed from L1 cache.
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} 
		return b;


	}
	

}
