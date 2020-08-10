package tester;

import org.hibernate.*;

import dao.CustomerDaoImpl;
import pojos.Customer;
import pojos.CustomerType;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GetDetails {

	public static void main(String[] args) {
			try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter customer id");
				CustomerDaoImpl dao=new CustomerDaoImpl();
			System.out.println(dao.getDetails(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
