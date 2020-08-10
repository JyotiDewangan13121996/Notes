package com.app.controllers;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.service.UserServiceIntf;

import pojos.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceIntf service;

	@GetMapping("/login")
	private String showLoginForm(User u) {
		System.out.println("show login form " + u);
		return "user/login";
	}

	@PostMapping("/login")
	private String processLoginForm(User u, HttpSession hs,RedirectAttributes flashMap,Model map) {
		System.out.println("process login form " + u);
		try {
			User u1=service.validateUser(u.getEmail(), u.getPass());
			//add validated user dtls to session scope
			hs.setAttribute("valid_user", u1);
			flashMap.addFlashAttribute("mesg","Admin Login Successful");
			return "redirect:/vendor/list";
			
		} catch (NoResultException e) {
			// invalid login
			map.addAttribute("mesg","Invalid Login , pls retry");
			
		}
		return "user/login";
	}

}
