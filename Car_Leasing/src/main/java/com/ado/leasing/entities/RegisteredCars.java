package com.ado.leasing.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registered_cars")
public class RegisteredCars {
	
	public RegisteredCars(){}
	
	public RegisteredCars(Car car, boolean registered){
		this.car = car;
		registered = true;
	}
	
	public RegisteredCars(User user, Car car, boolean registered){
		this.user = user;
		this.car = car;
		this.registered = true;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_number",referencedColumnName="id_number", nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="reg_num", referencedColumnName="reg_num", nullable=false)
	private Car car;
	
	@Column(name="registered")
	private boolean registered;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	
	
	

}
