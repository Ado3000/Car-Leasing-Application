package com.ado.leasing.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ado.leasing.entities.Car;
import com.ado.leasing.entities.RegisteredCars;
import com.ado.leasing.entities.User;
import com.ado.leasing.service.CarServiceInterface;
import com.ado.leasing.service.UserServiceInterface;


@Controller
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarServiceInterface carService;
	
	@Autowired
	private UserServiceInterface userService;

	@GetMapping("/listcars")
	public String listCars(Model theModel){
		List<Car> theCars = carService.getCars();
		theModel.addAttribute("cars", theCars);
		return "layout";
	}
	
	@GetMapping("/leasecar")
	public String leaseCar(@RequestParam("id") BigInteger id, @RequestParam("registration") String reg) {
		Car theCar = carService.getCar(reg);
		User theUser = userService.getUser(id);
		carService.leaseCar(new RegisteredCars(theUser, theCar));
		return "redirect:/listcars";
	}
	
}
