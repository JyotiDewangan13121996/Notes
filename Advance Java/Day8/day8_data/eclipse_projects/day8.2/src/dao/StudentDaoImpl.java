package dao;

import static utils.HibernateUtils.getSf;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String admitStudent(Student s, String courseName) {
		String jpql = "select c from Course c where c.name=:nm";
		String mesg = "Student admission failed";
		// Session
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			Course c = hs.createQuery(jpql, Course.class).setParameter("nm", courseName).getSingleResult();
			// c --PERSISTENT 
			c.addStudent(s);
			tx.commit();
			mesg = "Student admitted to " + courseName + " course ";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

}
