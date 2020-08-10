package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.CompanyDaoIntf;

@Controller
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private CompanyDaoIntf dao;

	@PostMapping("/add")
	public String addVendorToCompany(@RequestParam int compId, @RequestParam int vendorId,RedirectAttributes flashMap) {
		System.out.println("in add vendor to company " + compId + " " + vendorId);
		flashMap.addFlashAttribute("mesg",dao.addVendorToCompany(vendorId, compId));
		return "redirect:/vendor/list";
	}
	@PostMapping("/remove")
	public String removeVendorFromCompany(@RequestParam int compId, @RequestParam int vendorId,RedirectAttributes flashMap) {
		System.out.println("in remove vendor from company " + compId + " " + vendorId);
		flashMap.addFlashAttribute("mesg",dao.removeVendorFromCompany(vendorId, compId));
		return "redirect:/vendor/list";
	}
	@GetMapping("/list")
	public String listCompanies(@RequestParam int id,Model map)
	{
		System.out.println("in list companies "+id);
		map.addAttribute("vendor_companies", dao.listCompanies(id));
		map.addAttribute("all_companies", dao.allCompanies());
		return "company/list";
	}

}
