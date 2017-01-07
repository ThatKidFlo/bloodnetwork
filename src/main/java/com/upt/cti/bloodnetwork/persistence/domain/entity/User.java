package com.upt.cti.bloodnetwork.persistence.domain.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String name;
	
	@Embedded
	private LatLong location;
	
	@Enumerated(EnumType.STRING)
	@Column
	private BloodType bloodType;
	
	@Column
	private int weight;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LatLong getLocation() {
		return location;
	}

	public void setLocation(LatLong location) {
		this.location = location;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
