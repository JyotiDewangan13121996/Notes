package tester;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;
import java.util.Scanner;

import static utils.HibernateUtils.getSf;

public class BulkDeleteBooks {

	public static void main(String[] args) {
		HibernateUtils.getSf();

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter book price ");

			double price1 = sc.nextDouble();
			int count = 0;
			String hql = "delete from  Book b  where  b.price > :pr";

			// hs
			Session hs = getSf().getCurrentSession();
			// tx
			Transaction tx = hs.beginTransaction();
			try {
				count = hs.createQuery(hql).setParameter("pr", price1).executeUpdate();
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				throw e;
			}

			System.out.println("Row Update count " + count);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtils.getSf().close();
		}

	}

}
