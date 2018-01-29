package com.ado.leasing.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ado.leasing.entities.Car;
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

	@Override
	public List<RegisteredCars> getRegisteredCars() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<RegisteredCars> theQuery = currentSession.createQuery("from RegisteredCars order by id",
				RegisteredCars.class);
		List<RegisteredCars> registeredCars = theQuery.getResultList();
		return registeredCars;
	}
	
	

}
