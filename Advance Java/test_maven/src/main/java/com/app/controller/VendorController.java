package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.VendorService;

@Controller
@RequestMapping("/vendor") //optional BUT reco
public class VendorController {
	@Autowired
	private VendorService service;
	public VendorController() {
		System.out.println("in vendor controller constr "+service);
		
	}
	@RequestMapping("/list")
	public String listAllVendors(Model map)
	{
		System.out.println("in list vendors...."+service);
		map.addAttribute("vendor_list", service.listVendors());
		return "/vendor/list";
	}

}
