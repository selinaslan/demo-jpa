package com.example.jpa.demojpa.entity;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;

	private String lastName;

	private Integer age;

	private String role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserDetail> userDetail;

	protected User() {

	}

	public User(String firstName, String lastName, Integer age, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.role = role;
	}

	public User(String firstName, String lastName, Integer age, String role, UserDetail... userDetails) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.role = role;
		this.userDetail = Stream.of(userDetails).collect(Collectors.toList());
		this.userDetail.forEach(x -> x.setUser(this));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", role="
				+ role + "]";
	}

}
