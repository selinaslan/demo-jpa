package com.example.jpa.demojpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserDetail {

	@Id
	@GeneratedValue
	private Long id;

	private String country;

	private String address;

	private Integer phoneNumber;

	@ManyToOne
	@JoinColumn
	private User user;

	protected UserDetail() {

	}

	public UserDetail(String country, String address, Integer phoneNumber) {
		super();
		this.country = country;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", country=" + country + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ "]";
	}

}
