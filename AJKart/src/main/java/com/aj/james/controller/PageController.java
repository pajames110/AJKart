package com.aj.james.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/")
	public String getPage(){
		
		return "index";
	}
	
	@RequestMapping("/index")
	public String getIndexPage(){
		
		return "index";
	}
	
	@RequestMapping("/about")
	public String getAboutPage(){
		
		return "about";
	}
	
	@RequestMapping("/register")
	public String getRegisterPage(){
		
		return "register";
	}
	
	@RequestMapping("/contact")
	public String getContactPage(){
		
		return "contact";
	}

}
