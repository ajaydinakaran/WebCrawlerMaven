package com.webcrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * This class contains all the web pages mapping
 * */
@Controller
public class WebController {

	@GetMapping("/home")
	public String hello(Model model) {

		return "home";
	}
	@GetMapping("/link1")
	public String link1(Model model) {

		return "link1";
	}
	@GetMapping("/link2")
	public String link2(Model model) {

		return "link2";
	}
	@GetMapping("/link3")
	public String link3(Model model) {

		return "link3";
	}
}
