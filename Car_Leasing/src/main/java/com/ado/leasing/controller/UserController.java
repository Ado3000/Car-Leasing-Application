package com.ado.leasing.controller;

import java.math.BigInteger;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping("/editUser")
	public String editUser(@ModelAttribute("user") User theUser){
		userService.editUser(theUser);
		return "redirect:/welcome";
	}

	@GetMapping("/updateuser")
	public String updateCar(Model theModel, Principal principal) {
		String id = principal.getName(); //get logged in username
		User theUser = userService.getUser(new BigInteger(id));
		theModel.addAttribute("user", theUser);
		return "edit-form";
	}
	
	@GetMapping("/userInfo")
	public String userInfo(Model theModel, Principal principal) {
		String id = principal.getName(); //get logged in username
		User theUser = userService.getUser(new BigInteger(id));
		theModel.addAttribute("user", theUser);
		return "user-info";
	}

	@RequestMapping("/welcome")
	public String welcomePage(){
		return "welcome";
	}


}
