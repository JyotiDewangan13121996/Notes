package tester;

import org.hibernate.*;

import dao.CustomerDaoImpl;
import pojos.Customer;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class UpdateCustomerDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			CustomerDaoImpl dao = new CustomerDaoImpl();
			System.out.println("customer id , oreg amt offset , new password");
			System.out.println(dao.updateCustomerDetails(sc.nextInt(), sc.nextDouble(), sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
