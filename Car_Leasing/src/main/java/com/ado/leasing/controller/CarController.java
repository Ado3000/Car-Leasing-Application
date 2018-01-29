package com.ado.leasing.controller;

import java.math.BigInteger;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		List<Car> theCars;
		theCars = carService.notRegisteredCars();
		theModel.addAttribute("cars", theCars);
		return "leaselist";
	}

	@GetMapping("/leasecar")
	public String leaseCar(@RequestParam("registration") String reg, Principal principal) {
		String id = principal.getName(); //get logged in username
		Car theCar = carService.getCar(reg);
		User theUser = userService.getUser(new BigInteger(id));
		theCar.setRegistered(true);
		carService.saveCar(theCar);
		carService.leaseCar(new RegisteredCars(theUser, theCar, true));
		return "redirect:/cars/listcars";
	}
	
	@GetMapping("/showcars")
	public String showUserCars(Model theModel, Principal principal) {
		List<Car> theCars = carService.getCars();
		List<RegisteredCars> registeredCars = carService.getRegisteredCars();
		List<Car> userCars = new ArrayList<Car>();
		String id = principal.getName(); //get logged in username
		
		for(int i = 0; i < registeredCars.size(); i++){
			if(id.equals(registeredCars.get(i).getUser().getId().toString())){
				for(int z = 0; z < theCars.size(); z++){
					if(registeredCars.get(i).getCar().getRegNum().equals(theCars.get(z).getRegNum())){
						userCars.add(theCars.get(z));
					}
				}
			}
		}
		
		theModel.addAttribute("cars", userCars);
		return "user_cars";
	}

}
