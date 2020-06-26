package com.learntocodemm.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learntocodemm.demo.entity.Users;
import com.learntocodemm.demo.repository.UsersRepository;

@Controller
public class UsersController {
	@Autowired
	UsersRepository usersRepository;
		
	@GetMapping("/user")
	public String view(@RequestParam(name="name", required=false, defaultValue="null") String name,Model model) {
		Users usr = usersRepository.findByname(name);
		model.addAttribute("name",usr.getName());
		return "greeting";
	}
	
	@GetMapping("/addUsers")
	public String add(@RequestParam(name="name", required=false, defaultValue="null") String name,Model model) {
		Users users = new Users();
		users.setName(name);
		usersRepository.save(users);
		model.addAttribute("name",name);
		return "greeting";
	}
}
