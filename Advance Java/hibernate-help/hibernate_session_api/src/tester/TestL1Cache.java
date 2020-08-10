package tester;

import org.hibernate.*;

import pojos.Vendor;

import static utils.HibernateUtils.*;

public class TestL1Cache {

	public static void main(String[] args) {
		try {
			Vendor v = null;
			Session hs = getSf().getCurrentSession();
			// tx
			Transaction tx = hs.beginTransaction();
			try {
				v = hs.get(Vendor.class, 8);
				v = hs.get(Vendor.class, 8);
				v = hs.get(Vendor.class, 8);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				throw e;
			} 
			System.out.println("Vendor dtls " + v);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getSf().close();// cn pool will be destroyed.
		}

	}

}
