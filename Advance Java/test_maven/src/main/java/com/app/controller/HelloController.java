package com.app.controller;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // mandatory
public class HelloController {
	public HelloController() {
		System.out.println("in hello controller constr...");
	}

	@PostConstruct
	public void myInit() {
		System.out.println("in init");
	}

	// request handling method
	@RequestMapping("/hello") // MANDATORY
	public String sayHello() {
		System.out.println("in say hello");
		return "welcome";
	}

	// request handling method
	@RequestMapping("/hello2") // MANDATORY
	public ModelAndView sayHello2() {
		System.out.println("in say hello2");
		return new ModelAndView("welcome", "server_dt", new Date());
	}

	// request handling method to test o.s.ui.Model
	@RequestMapping("/hello3") // MANDATORY
	public String sayHello3(Model map) {
		System.out.println("in say hello3 " + map);
		map.addAttribute("server_dt", new Date());
		map.addAttribute("num_list", Arrays.asList(1, 2, 3, 4));
		System.out.println("in say hello3 " + map);
		return "welcome";
	}

	// request handling method to test req params
	@RequestMapping("/hello4") // MANDATORY
	public String sayHello4(Model map,@RequestParam String nm,
			@RequestParam(name="age") int age123,@RequestParam Date join_date) {
		System.out.println("in say hello4 " + map);
		map.addAttribute("user_nm", nm);
		map.addAttribute("user_age", age123);
		map.addAttribute("user_dt", join_date);
		return "welcome";
	}

}
