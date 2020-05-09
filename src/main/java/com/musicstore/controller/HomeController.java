package com.musicstore.controller;

import org.springframework.stereotype.Controller;//control+shift+o = add package automatic
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

}
