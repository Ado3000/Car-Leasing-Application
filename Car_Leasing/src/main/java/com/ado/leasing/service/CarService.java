package com.ado.leasing.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ado.leasing.dao.CarDAOInterface;
import com.ado.leasing.entities.Car;

@Service
public class CarService implements CarServiceInterface {
	
	@Autowired
	private CarDAOInterface carDAO;


	@Override
	@Transactional
	public List<Car> getCars() {
		return carDAO.getCars();
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

}
