package com.ado.leasing.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ado.leasing.dao.UserDAOInterface;
import com.ado.leasing.dao.UserRoleDAOInterface;
import com.ado.leasing.entities.User;
import com.ado.leasing.entities.UserRole;

@Service
public class UserService implements UserServiceInterface, UserDetailsService  {
	
	@Autowired
	private UserDAOInterface userDAO;
	
	@Autowired
	private UserRoleDAOInterface userRoleDAO;
	 
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User theUser) {
		theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));
		userDAO.saveUser(theUser);
		userRoleDAO.saveRole(new UserRole(theUser, "ROLE_USER"));
	}

	@Override
	@Transactional
	public User getUser(BigInteger id) {
		User user = userDAO.getUser(id);
		return user;
	}
	
	
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}
	
	private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
			List<GrantedAuthority> authorities) {
			return new 
					org.springframework.security.core.userdetails.User(user.getId().toString(), user.getPassword(), true, true, true, true, authorities);
		}
	
	@Override
	@Transactional
	public void delelteUser(BigInteger id) {
		userRoleDAO.deleteUserRole(id);
		userDAO.deleteUser(id);
	}

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		BigInteger id = new BigInteger(arg0);
		User user = userDAO.getUser(id);
		List<GrantedAuthority> authorities =
                                      buildUserAuthority(user.getUserRole());

		return buildUserForAuthentication(user, authorities);
	}

	@Override
	@Transactional
	public void editUser(User theUser) {
		theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));
		userDAO.saveUser(theUser);
	}

}
