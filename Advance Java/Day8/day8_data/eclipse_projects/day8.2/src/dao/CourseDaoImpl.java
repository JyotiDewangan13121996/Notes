package dao;

import pojos.Course;
import org.hibernate.*;
import static utils.HibernateUtils.*;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String launchCourse(Course c) {
		String mesg = "Launching course failed";
		// Session
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			/*
			 * System.out.println(c.getId()); c.setId(123);
			 */ hs.persist(c);//persistent
			tx.commit();
			mesg = "Launched course with ID =" + c.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

}
