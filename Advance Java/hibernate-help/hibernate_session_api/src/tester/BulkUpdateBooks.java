package tester;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;


import static utils.HibernateUtils.getSf;

public class BulkUpdateBooks {

	public static void main(String[] args) {
		HibernateUtils.getSf();

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter author & disc amount");
			String auth=sc.next();
			double amt=sc.nextDouble();
			int count = 0;
			String hql = "update Book b SET b.price =b.price-:pr where  b.author = :au";

			// hs
			Session hs = getSf().getCurrentSession();
			// tx
			Transaction tx = hs.beginTransaction();
			try {
				
				count = hs.createQuery(hql).setParameter("pr", amt)
						.setParameter("au", auth).executeUpdate();
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				throw e;
			}

			System.out.println("Row Update count "+count);

		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateUtils.getSf().close();

	}

}
