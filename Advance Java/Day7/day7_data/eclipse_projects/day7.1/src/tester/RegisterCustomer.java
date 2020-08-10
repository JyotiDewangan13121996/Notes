package tester;

import org.hibernate.*;

import dao.CustomerDaoImpl;
import pojos.Customer;
import pojos.CustomerType;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RegisterCustomer {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // day-mon-yr
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter customer details nm em pass cPass role amt dt type");
			Customer c = new Customer(sc.next(), sc.next(), sc.next(), 
					sc.next(), sc.next(), sc.nextDouble(),
					sdf.parse(sc.next()), CustomerType.valueOf(sc.next().toUpperCase()));
		//c -- transient object -- obj heap , but neither part of L1 cache nor DB 
		//invoke dao's method for reg new user
			CustomerDaoImpl dao=new CustomerDaoImpl();
			System.out.println(dao.registerCustomer(c));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
