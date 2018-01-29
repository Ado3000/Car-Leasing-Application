package com.ado.leasing.entities;

import java.math.BigInteger;
import java.util.Set;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="users")
@Access(AccessType.FIELD)
public class User {
	
	public User(){};
	
	public User(BigInteger id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public User(BigInteger id, String password, Set<UserRole> userRole) {
			this.id = id;
			this.password = password;
			this.userRole = userRole;
		}
	
	@Id
	@Column(name="id_number")	
	private BigInteger id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;
	
	@Column(name="city")
	private String city;
	
	@Column(name="phonenumber")
	private BigInteger phoneNumber;
	
	@Column(name="adress")
	private String adress;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(targetEntity= UserRole.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private Set<UserRole> userRole;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [id_number=" + id + ", name=" + name + ", password=" + password + ", city=" + city
				+ ", phoneNumber=" + phoneNumber + ", adress=" + adress + "]";
	}
	
	
	
}
