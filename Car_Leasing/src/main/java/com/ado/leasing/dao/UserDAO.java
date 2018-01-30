package com.ado.leasing.dao;

import java.math.BigInteger;
import java.util.ArrayList;
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
		currentSession.saveOrUpdate(theUser);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(BigInteger id) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<User> users = new ArrayList<User>();

		users = currentSession
			.createQuery("from User where id_number=?")
			.setParameter(0, id)
			.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void deleteUser(BigInteger id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from User where id_number=:id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}

}
