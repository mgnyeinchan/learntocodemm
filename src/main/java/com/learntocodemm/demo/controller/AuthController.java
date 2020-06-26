package com.learntocodemm.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AuthController {

	@GetMapping("/")
	public String home() {
		return "welcome";
	}
	@GetMapping("Greeting")
	public String hello(@RequestParam(name="username", required=false, defaultValue="Hello World") String name,Model model) {
		//return name;
		model.addAttribute("name",name);
		return "greeting";
	}
	
	
}
