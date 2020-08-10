package utils;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	private static SessionFactory sf;
	static {
		try {
			StandardServiceRegistry ref = new StandardServiceRegistryBuilder().configure().build();
			sf=new MetadataSources(ref).buildMetadata().buildSessionFactory();
			System.out.println("SF created!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSf() {
		return sf;
	}

}
