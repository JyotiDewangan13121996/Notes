package dao;

import java.util.Date;
import java.util.List;

import pojos.Customer;

public interface ICustomerDao {
	String registerCustomer(Customer c);

	Customer getDetails(int custId);

	List<Customer> getAllCustomers();

	List<Customer> getSelectedCustomers(Date strtDate, Date endDate, double amount);

	String updateCustomerDetails(int custId, double offsetAmount, String newPass);

	List<Customer> updateCustomers(Date dt, double discount);
	
	int bulkUpdateCustomers(Date dt, double discount);
	
	String deleteCustomerDetails(int custId);

}
