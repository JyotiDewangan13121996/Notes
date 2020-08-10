package tester;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Book;
import utils.HibernateUtils;

public class TestGetAPI {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			SessionFactory sf = HibernateUtils.getSf();
			System.out.println("Enter book id ");
			int id = sc.nextInt();
			Session hs = sf.getCurrentSession();
			// tx
			Transaction tx = hs.beginTransaction();
			Book b1 = null;
			try {
				b1 = hs.get(Book.class, id);// b1-- null or not null
				// b1.getTitle();
				if (b1 != null)
					System.out.println(b1.getClass().getName());
				else 
					System.out.println("Book id invalid ....");
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				throw e;
			}
			// b1 --- DETACHED
			System.out.println(b1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtils.getSf().close();
		}

	}

}
