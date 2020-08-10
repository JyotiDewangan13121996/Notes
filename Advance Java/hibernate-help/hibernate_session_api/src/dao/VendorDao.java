package dao;

import java.util.List;

import pojos.Vendor;

public interface VendorDao {

	Vendor getDetails(int id);

	List<Vendor> fetchAllVendors();

	Integer saveDetails(Vendor v) throws Exception;

	// update vendor details
	Vendor updateDetails(int id, String city1, String ph);

}