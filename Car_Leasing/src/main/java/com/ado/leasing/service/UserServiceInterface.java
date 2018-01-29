package com.ado.leasing.service;

import java.math.BigInteger;
import java.util.List;

import com.ado.leasing.entities.User;

public interface UserServiceInterface {
	
	public List<User> getUsers();
	
	public void saveUser(User theUser);
	
	public void editUser(User theUser);
	
	public User getUser(BigInteger id);
	
	public void delelteUser(BigInteger id);

}
