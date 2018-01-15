package com.ado.leasing.service;

import java.util.List;
import com.ado.leasing.entities.Car;

public interface CarServiceInterface {
	
	public List<Car> getCars();
	
	public void saveCar(Car theCar);
	
	public Car getCar(String reg);
	
	public void deleteCar(String reg);
	
	

}
