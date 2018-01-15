package com.ado.leasing.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ado.leasing.dao.UserDAOInterface;
import com.ado.leasing.entities.User;

@Service
public class UserService implements UserServiceInterface {
	
	@Autowired
	private UserDAOInterface userDAO;

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
		
	}

	@Override
	@Transactional
	public void saveUser(User theUser) {
		userDAO.saveUser(theUser);
	}

	@Override
	@Transactional
	public User getUser(int id) {
		return userDAO.getUser(id);
	}

	@Override
	@Transactional
	public void delelteUser(BigInteger id) {
		userDAO.deleteUser(id);
	}

}
