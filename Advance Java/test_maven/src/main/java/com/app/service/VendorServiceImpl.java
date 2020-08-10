package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.pojos.Vendor;

@Service("vendor_service_hm")
public class VendorServiceImpl implements VendorService {
	private HashMap<Integer, Vendor> vendors;

	public VendorServiceImpl() {
		//create n populate map of vendors
		vendors=new HashMap<>();
		vendors.put(1, new Vendor(1, "abc", "abc@gmail", "1234", "pune", "123436"));
		vendors.put(2, new Vendor(2, "abc2", "abc2@gmail", "1235", "mumbai", "563436"));
		System.out.println("in service constr");
	}

	@Override
	public List<Vendor> listVendors() {
		
		return new ArrayList<>(vendors.values());
	}

}
