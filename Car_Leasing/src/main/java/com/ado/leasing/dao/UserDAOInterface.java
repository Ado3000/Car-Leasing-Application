package com.ado.leasing.dao;
import java.math.BigInteger;
import java.util.List;

import com.ado.leasing.entities.User;

public interface UserDAOInterface {
	
	public List<User> getUsers();
	
	public void saveUser(User theUser);
	
	public User getUser(BigInteger id);
	
	public void deleteUser(BigInteger id);

}
