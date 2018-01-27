package com.ado.leasing.dao;

import java.math.BigInteger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ado.leasing.entities.UserRole;

@Repository
public class UserRoleDAO implements UserRoleDAOInterface {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("rawtypes")
	public void deleteUserRole(BigInteger id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from UserRole where id=:id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();

	}

	@Override
	public void saveRole(UserRole role) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(role);
	}



	
	
	
	
	

}
