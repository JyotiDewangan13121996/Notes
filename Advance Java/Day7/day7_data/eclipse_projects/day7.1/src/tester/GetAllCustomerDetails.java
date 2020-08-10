package tester;

import org.hibernate.*;

import dao.CustomerDaoImpl;
import pojos.Customer;

import static utils.HibernateUtils.*;

import java.util.function.Consumer;

public class GetAllCustomerDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf()) {
			CustomerDaoImpl dao = new CustomerDaoImpl();
			/*dao.getAllCustomers().forEach(new Consumer<Customer>() {

				@Override
				public void accept(Customer arg0) {
					System.out.println(arg0);

				}

			});*/
		//	dao.getAllCustomers().forEach(c->System.out.println(c));
			//OR method ref
		//	dao.getAllCustomers().forEach(System.out::println);
			for(Customer c : dao.getAllCustomers())
				System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
