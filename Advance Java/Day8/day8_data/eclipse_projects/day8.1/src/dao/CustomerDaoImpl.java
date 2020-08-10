package dao;

import pojos.Customer;
import org.hibernate.*;
import static utils.HibernateUtils.*;

import java.util.Date;
import java.util.List;

public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public String registerCustomer(Customer c) {
		String mesg = "customer reg failed";
		// get session SF
		Session hs = getSf().getCurrentSession();//NEW session
		Session hs2 = getSf().getCurrentSession();//Existing Session
		System.out.println(hs == hs2);//true
		Transaction tx = hs.beginTransaction();
		System.out.println("open " + hs.isOpen() + " connected " + hs.isConnected());

		// L1 cache is created
		try {
			// c --- TRANSIENT
			// register customer
			Integer id = (Integer) hs.save(c);// c --PERSISTENT
			mesg = "Customer reged with ID " + id;
			tx.commit();// insert query will be fired
			System.out.println("open " + hs.isOpen() + " connected " + hs.isConnected());

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} /*
			 * finally { // close session if (hs != null) hs.close();// session closed --L1
			 * cache destroyed , pooled out DB cn rets to the pool }
			 */
		System.out.println("open " + hs.isOpen() + " connected " + hs.isConnected());

		return mesg;// c --DETACHED from L1 cache BUT exists in DB
	}

	@Override
	public Customer getDetails(int custId) {
		Customer c = null;// DOESn't exist
		// get Session from SF
		Session hs = getSf().getCurrentSession();
		// begin tx
		Transaction tx = hs.beginTransaction();
		try {
			c = hs.get(Customer.class, custId);// int -->Integer --> Serialializable
			// c -- if id exists -- PERSISTENT
			c = hs.get(Customer.class, custId);// int -->Integer --> Serialializable
			c = hs.get(Customer.class, custId);// int -->Integer --> Serialializable
			tx.commit();// auto dirty checking --no DML query fired
			// session close -- L1 cache destroyed , cn rets to pool
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return c;// c -- DETACHED
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> l1 = null;
		String jpql = "select c from Customer c";
		// Session
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, Customer.class).getResultList();
			// l1 -- list of PERSISTENT POJOs
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return l1;// l1 -- list of DETACHED POJOs
	}

	@Override
	public List<Customer> getSelectedCustomers(Date strtDate, Date endDate, double amount) {
		List<Customer> l1 = null;
		String jpql = "select c from Customer c where c.regDate between :strt and :end and c.regAmount > :amt";
		// session
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, Customer.class).setParameter("strt", strtDate).setParameter("end", endDate)
					.setParameter("amt", amount).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

	@Override
	public String updateCustomerDetails(int custId, double offsetAmount, String newPass) {
		String mesg = "customer updation failed";
		// Session
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		Customer c = null;
		try {
			// find customer by id
			c = hs.get(Customer.class, custId);// select
			if (c != null) {

				// customer found --- c -- PERSISTENT
				c.setRegAmount(c.getRegAmount() + offsetAmount);
				c.setPassword(newPass);
				mesg = "customer details updated....";
			}
			tx.commit();// HIbernate performs auto dirty checking @ commit
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		// c -- DETACHED
		c.setPassword("5577");
		return mesg;
	}

	@Override
	public List<Customer> updateCustomers(Date dt, double discount) {
		String jpql = "select c from Customer c where c.regDate < :date";
		List<Customer> l1 = null;
		// Session
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, Customer.class).setParameter("date", dt).getResultList();
			for (Customer c : l1)
				c.setRegAmount(c.getRegAmount() - discount);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

	@Override
	public int bulkUpdateCustomers(Date dt1, double discount) {
		int count = 0;
		String jpql = "update Customer c set c.regAmount=c.regAmount-:disc where c.regDate < :dt";
		// Session
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();

		try {
			count = hs.createQuery(jpql).setParameter("disc", discount).setParameter("dt", dt1).executeUpdate();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return count;
	}

	@Override
	public String deleteCustomerDetails(int custId) {
		String mesg="deletion of customer record failed...";
		//Session
		Session hs=getSf().getCurrentSession();
		//tx
		Transaction tx=hs.beginTransaction();
		try {
			//get customer dtls
			Customer c=hs.get(Customer.class, custId);
			if(c != null)
			{
				hs.delete(c);//c --marked for removal 
				mesg="customer details deleted";
			}
			tx.commit();
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public List<Object[]> getSelectedCustomers(Date dt1) {
		List<Object[]> l1=null;
		String jpql="select c.name,c.regAmount,c.email from Customer c where c.regDate < :dt";
		//Session
		Session hs=getSf().getCurrentSession();
		//tx
		Transaction tx=hs.beginTransaction();
		try {
			l1=hs.createQuery(jpql,Object[].class).setParameter("dt", dt1).getResultList();
			tx.commit();
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return l1;
	}
	
	

}
