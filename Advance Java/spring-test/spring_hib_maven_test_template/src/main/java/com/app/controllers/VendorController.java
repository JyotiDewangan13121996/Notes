package com.app.controllers;

import javax.annotation.PostConstruct;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.service.VendorServiceIntf;

import pojos.Vendor;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private VendorServiceIntf service;
	
	@PostConstruct
	public void init()
	{
		System.out.println("init of "+getClass().getName());
	}

	@GetMapping("/list")
	public String listVendors(Model map) {
		System.out.println("in controller's : list vendors "+service);
		map.addAttribute("vendor_list", service.listVendors());
		return "vendor/list";
	}

	@GetMapping("/add")
	public String showRegForm(Vendor v) {
		System.out.println("in vendor reg show form");
		return "vendor/register";
	}

	@PostMapping("/add")
	public String proecessRegForm(Vendor v, RedirectAttributes flashMap, Model map) {
		System.out.println("in vendor process reg form " + v);
		System.out.println(v.getCard());
		System.out.println(v.getVehicles());
		// rev values
		System.out.println(v.getCard().getMyVendor());
		System.out.println(v.getVehicles().get(0).getMyVendor());
		try {
			flashMap.addFlashAttribute("mesg", service.registerVendor(v));
		} catch (Exception e) {
			// error in registering new vendor
			if (e instanceof ConstraintViolationException)
				map.addAttribute("mesg", "Duplicate Data " + e.getCause().getMessage());
			else
				map.addAttribute("mesg", "Server Internal Error " + e.getCause().getMessage());
			return "vendor/register";
		}
		return "redirect:/vendor/list";
	}

	// deleting vendor details
	@GetMapping("/delete/{vendorId}")
	public String deleteVendor(@PathVariable int vendorId, RedirectAttributes flashMap) {
		System.out.println("in delete vendor " + vendorId);
		flashMap.addFlashAttribute("message", service.deleteVendor(vendorId));

		return "redirect:/vendor/list";
	}

	// show update form pre populated with db dtls
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam int id, Model map) {
		System.out.println("in show update form " + id);
		Vendor v = service.getVendorDetails(id);
		System.out.println(v);
		map.addAttribute("vendor", v);
		return "/vendor/update";
	}

	// process update form
	@PostMapping("/update")
	public String processUpdateForm(Vendor v, RedirectAttributes flashMap) {
		System.out.println("in process update " + v);
		flashMap.addFlashAttribute("message", service.updateVendor(v));
		return "redirect:/vendor/list";
	}

	// fetching selected vendor details
	@GetMapping("/details/{vendorId}")
	public String fetchVendorDetails(@PathVariable int vendorId, Model map) {
		System.out.println("in fetch vendor details " + vendorId);
		map.addAttribute("vendor_dtls", service.getVendorDetails(vendorId));
		return "vendor/details";
	}

}
