package com.ado.leasing.service;

import java.math.BigInteger;
import java.util.List;
import com.ado.leasing.entities.Car;
import com.ado.leasing.entities.RegisteredCars;

public interface CarServiceInterface {
	
	public List<Car> getCars();
	
	public void saveCar(Car theCar);
	
	public Car getCar(String reg);
	
	public void deleteCar(String reg);
	
	public List<Car> notRegisteredCars();
	
	void leaseCar(RegisteredCars registeredCar);
	
	public List<RegisteredCars> getRegisteredCars();

}
