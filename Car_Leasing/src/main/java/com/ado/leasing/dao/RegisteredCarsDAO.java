package com.ado.leasing.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ado.leasing.entities.RegisteredCars;

@Repository
public class RegisteredCarsDAO implements RegisteredCarsDAOInterface {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void leaseCar(RegisteredCars registeredCar) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(registeredCar);
	}
	
	

}
