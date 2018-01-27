package com.ado.leasing.dao;

import java.math.BigInteger;
import com.ado.leasing.entities.UserRole;

public interface UserRoleDAOInterface {
	
	public void deleteUserRole(BigInteger id);
	
	public void saveRole(UserRole role);

}
