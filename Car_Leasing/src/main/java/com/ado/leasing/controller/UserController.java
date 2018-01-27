package com.ado.leasing.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ado.leasing.entities.User;
import com.ado.leasing.entities.UserRole;
import com.ado.leasing.service.UserServiceInterface;

@Controller
public class UserController {

	@Autowired
	private UserServiceInterface userService;


	@GetMapping("/registrationform")
	public String registerUser(Model theModel){
		User theUser = new User();
		theModel.addAttribute("user", theUser);
		return "registration-form";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User theUser, UserRole role){
		userService.saveUser(theUser);
		return "redirect:/welcome";
	}

	@GetMapping("/admindelete")
	public String deleteUser(@RequestParam("id") BigInteger id){
		userService.delelteUser(id);
		return "redirect:/user-list";
	}

	@RequestMapping("/welcome")
	public String welcomePage(){
		return "welcome";
	}


}
