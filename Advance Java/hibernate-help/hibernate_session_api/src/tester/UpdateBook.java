//user supplies --title & hib  updates price , if book title  exists
package tester;


import java.util.Scanner;

import org.hibernate.*;

import pojos.*;
import static utils.HibernateUtils.*;

public class UpdateBook {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf()) {
			System.out.println("Enter existing book id");
			int id = sc.nextInt();
			Session session = sf.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Book b1 = session.get(Book.class, id);//b1 --persistent
			tx.commit();
			System.out.println("Book Details " + b1);//b1 -- detached
			System.out.println("Enter book price increment");
			//updating state of detached pojo
			b1.setPrice(b1.getPrice() +sc.nextDouble());
			session = sf.getCurrentSession();
			tx = session.beginTransaction();
			System.out.println("session contains b1"+session.contains(b1));
			session.update(b1);//DETACHED ---> PERSISTENT
			System.out.println(session.contains(b1));
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
