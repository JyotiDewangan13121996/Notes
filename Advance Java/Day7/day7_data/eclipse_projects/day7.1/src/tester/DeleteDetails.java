package tester;

import org.hibernate.*;

import dao.CustomerDaoImpl;
import pojos.Customer;
import pojos.CustomerType;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DeleteDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter customer id , for deleting details");
			CustomerDaoImpl dao = new CustomerDaoImpl();
			System.out.println(dao.deleteCustomerDetails(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
