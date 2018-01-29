package com.ado.leasing.dao;

import java.util.List;

import com.ado.leasing.entities.RegisteredCars;

public interface RegisteredCarsDAOInterface {
	
	public void leaseCar(RegisteredCars registeredCar);
	
	public List<RegisteredCars> getRegisteredCars();

}
