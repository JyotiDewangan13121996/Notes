package dao;

import org.hibernate.*;
import pojos.*;
import static utils.HibernateUtils.*;

import java.util.List;

public class VendorDaoImpl implements VendorDao {
	@Override
	public Vendor getDetails(int id) {
		Vendor v = null;
		// get session from SF
		Session hs = getSf().openSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			v = hs.get(Vendor.class, id);// null ---id invalid
			// not --null ----v -- PERSISTENT
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();// l1 cache is destroyed
		}
		return v; // DETACHED POJO ref.
	}

	@Override
	public List<Vendor> fetchAllVendors() {
		String jpql = "select v from Vendor v";
		List<Vendor> l1 = null;
		// sess
		Session hs = getSf().openSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, Vendor.class).getResultList();// l1 --
																	// list of
																	// persistent
																	// pojos
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}
		return l1;// l1 -- list of DETACHED pojos
	}

	@Override
	public Integer saveDetails(Vendor v) throws Exception {
		Integer id = null;
		// get session from SF
		Session hs = getSf().openSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			id = (Integer) hs.save(v);// v --persistent
			System.out.println("Press enter to continue");
			System.in.read();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();// l1 cache is destroyed
		}
		return id;

	}

	// update vendor details
	@Override
	public Vendor updateDetails(int id, String city1, String ph) {
		Vendor v = null;
		// sess
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			v = hs.get(Vendor.class, id);
			if (v != null) {
				//v --- PERSISTENT
				v.setCity(city1);
				v.setPhoneNo(ph);
			} else
				System.out.println("Invalid vendor id....");
			//auto dirty checking
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		v.setCity(v.getCity().toUpperCase());
		return v;
	}
}
