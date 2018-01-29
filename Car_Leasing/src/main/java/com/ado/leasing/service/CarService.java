package com.ado.leasing.service;

import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ado.leasing.dao.CarDAOInterface;
import com.ado.leasing.dao.RegisteredCarsDAOInterface;
import com.ado.leasing.entities.Car;
import com.ado.leasing.entities.RegisteredCars;

@Service
public class CarService implements CarServiceInterface {
	
	@Autowired
	private CarDAOInterface carDAO;

	@Autowired
	private RegisteredCarsDAOInterface registeredCarDAO;

	@Override
	@Transactional
	public List<Car> getCars() {
		return carDAO.getCars();
	}
	
	@Override
	@Transactional
	public List<Car> notRegisteredCars(){
		return carDAO.notRegisteredCars();
	}

	@Override
	@Transactional
	public void saveCar(Car theCar) {
		carDAO.saveCar(theCar);
	}

	@Override
	@Transactional
	public Car getCar(String reg) {
		return carDAO.getCar(reg);
	}

	@Override
	@Transactional
	public void deleteCar(String reg) {
		carDAO.deleteCar(reg);
	}
	
	@Override
	@Transactional
	public void leaseCar(RegisteredCars registeredCar){
		registeredCarDAO.leaseCar(registeredCar);
	}
	
	@Override
	@Transactional
	public List<RegisteredCars> getRegisteredCars(){
		return registeredCarDAO.getRegisteredCars();
	}
	
}
