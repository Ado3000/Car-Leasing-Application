package com.ado.leasing.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ado.leasing.entities.Car;
import com.ado.leasing.entities.User;
import com.ado.leasing.entities.UserRole;
import com.ado.leasing.service.CarServiceInterface;
import com.ado.leasing.service.UserServiceInterface;

@Controller
public class AdminController {

	@Autowired
	private CarServiceInterface carService;

	@Autowired
	private UserServiceInterface userService;

	@PostMapping("/savecar")
	public String saveCar(@ModelAttribute("car") Car theCar){
		carService.saveCar(theCar);
		return "redirect:/registercar";
	}

	@RequestMapping("/admin**")
	public String getAdminPage(){
		return "admin-page";
	}

	@GetMapping("/registercar")
	public String registerCar(Model theModel) {
		Car theCar = new Car();
		theModel.addAttribute("car", theCar);
		return "car-form";
	}

	@GetMapping("/listcars")
	public String listCars(Model theModel){
		List<Car> theCustomers = carService.getCars();
		theModel.addAttribute("cars", theCustomers);
		return "car-list";
	}

	@GetMapping("/updatecar")
	public String updateCar(@RequestParam("registration") String reg, Model theModel) {
		Car theCar = carService.getCar(reg);
		theModel.addAttribute("car", theCar);
		return "car-form";
	}

	@GetMapping("/userlist")
	public String getUserList(Model theModel){
		List<User> theUser = userService.getUsers();
		theModel.addAttribute("users", theUser);
		return "user-list";
	}


	@GetMapping("delete")
	public String deleteCar(@RequestParam("registration") String reg){
		carService.deleteCar(reg);
		return "redirect:/listcars";
	}

	@GetMapping("/userdelete")
	public String deleteUser(@RequestParam("id") BigInteger id){
		userService.delelteUser(id);
		return "redirect:/userlist";
	}

}
