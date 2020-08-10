package tester;

import org.hibernate.*;

import dao.CustomerDaoImpl;
import pojos.Customer;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class GetSelectedCustomerDtls {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			CustomerDaoImpl dao = new CustomerDaoImpl();
			System.out.println("enter strt end amount");
			List<Customer> selectedCustomers = dao.getSelectedCustomers(sdf.parse(sc.next()), sdf.parse(sc.next()), sc.nextDouble());
			for(Customer c : selectedCustomers)
				System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
