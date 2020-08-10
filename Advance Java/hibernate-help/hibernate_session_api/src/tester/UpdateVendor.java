package tester;

import java.util.Scanner;

import dao.VendorDaoImpl;
import pojos.Vendor;

import static utils.HibernateUtils.*;

public class UpdateVendor {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			getSf();// hib frmwork loaded --booted.
			System.out.println("Enter vendor id , city , phone no");
			Vendor v= new VendorDaoImpl().updateDetails(sc.nextInt(), sc.next(), sc.next());
			System.out.println(v);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getSf().close();// cn pool will be destroyed.
		}

	}

}
