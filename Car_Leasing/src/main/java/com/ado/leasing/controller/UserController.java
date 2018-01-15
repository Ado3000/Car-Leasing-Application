package com.ado.leasing.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ado.leasing.entities.User;
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
	public void saveUser(@ModelAttribute("user") User theUser){
		userService.saveUser(theUser);
	}
	
	@GetMapping("/admindelete")
	public String deleteUser(@RequestParam("id") BigInteger id){
		userService.delelteUser(id);
		return "redirect:/user-list";
	}

}
