package com.ado.leasing.dao;

import java.util.List;
import com.ado.leasing.entities.Car;

public interface CarDAOInterface {
	
	public List<Car> getCars();
	
	public void saveCar(Car theCar);
	
	public Car getCar(String reg);
	
	public void deleteCar(String reg);
	

}
