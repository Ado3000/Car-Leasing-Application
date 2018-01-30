package com.ado.leasing.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ado.leasing.entities.Car;


@Repository
public class CarDAO implements CarDAOInterface {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Car> getCars() { 
				Session currentSession = sessionFactory.getCurrentSession();
				Query<Car> theQuery = currentSession.createQuery("from Car order by reg_num",
						Car.class);
				List<Car> cars = theQuery.getResultList();
				return cars;
	}
	
	@Override
	public List<Car> notRegisteredCars() { 
				Session currentSession = sessionFactory.getCurrentSession();
				Query<Car> theQuery = currentSession.createQuery("from Car where registered = 0",
						Car.class);
				List<Car> cars = theQuery.getResultList();
				return cars;
	}

	@Override
	public void saveCar(Car theCar) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCar);
		
	}
	
	@Override
	public Car getCar(String reg) {
		Session currentSession = sessionFactory.getCurrentSession();
		Car theCar = currentSession.get(Car.class, reg);
		return theCar;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void deleteCar(String reg) {
	Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from Car where reg_num=:registration");
		theQuery.setParameter("registration", reg);
		theQuery.executeUpdate();
	}

}
