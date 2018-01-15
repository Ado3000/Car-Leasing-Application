package com.ado.leasing.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ado.leasing.entities.User;

@Repository
public class UserDAO implements UserDAOInterface {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUsers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("from User order by id_number",
				User.class);
		List<User> users = theQuery.getResultList();
		return users;
	}

	@Override
	public void saveUser(User theUser) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(theUser);
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(BigInteger id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from User where id_number=:id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}

}
