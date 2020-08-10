package tester;

import org.hibernate.*;

import dao.CustomerDaoImpl;
import pojos.Customer;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class GetSelectedCustomerDtls2 {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			CustomerDaoImpl dao = new CustomerDaoImpl();
			System.out.println("enter date");
			List<Object[]> l1 = dao.getSelectedCustomers(sdf.parse(sc.next()));
		
			for(Object[] o : l1)
				System.out.printf("Name %s Amount %.1f Email %s %n",o[0],o[1],o[2]);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
