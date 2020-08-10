package tester;

import org.hibernate.*;

import dao.CustomerDaoImpl;
import pojos.Customer;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class OfferBulkDiscount {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			CustomerDaoImpl dao = new CustomerDaoImpl();
			System.out.println("date n discount");
			int count = dao.bulkUpdateCustomers(sdf.parse(sc.next()), sc.nextDouble());
			System.out.println(count + " customers updated...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
