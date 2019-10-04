package com.example.jpa.demojpa.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.demojpa.dao.UserRepository;
import com.example.jpa.demojpa.entity.User;

@Service
public class DemoJPAService {
	private static final Logger logger = LoggerFactory.getLogger(DemoJPAService.class);

	@Autowired
	private UserRepository dao;

	public User save(User user) {
		User saved = dao.save(user);
		logger.info("Saved user : " + saved.toString());
		return saved;
	}

	public boolean saveUserList(List<User> userList) {
		userList.stream().forEach(user -> {
			save(user);
		});
		return true;
	}

	public User findById(Long id) {
		Optional<User> findById = dao.findById(id);
		logger.info("Retrieved user : " + findById.get().toString());
		return findById.get();
	}

	public List<User> findAll() {

		List<User> findAll = dao.findAll();
		logger.info("Retrieved user list : " + findAll.toString());
		return findAll;
	}

	public User findByFirstName(String firstName) {

		User findByFirstName = dao.findByFirstName(firstName);
		logger.info("Retrieved user by first name : " + findByFirstName.toString());
		return findByFirstName;
	}

	public List<User> findByFirstNameOrLastName(String firstName, String lastName) {

		List<User> findByFirstNameOrLastName = dao.findByFirstNameOrLastName(firstName, lastName);
		logger.info("Retrieved user by first name or last name: " + findByFirstNameOrLastName.toString());
		return findByFirstNameOrLastName;
	}

	public List<User> findByAgeBetween(Integer age1, Integer age2) {

		List<User> findByAgeBetween = dao.findByAgeBetween(age1, age2);
		logger.info("Retrieved user by age between : " + findByAgeBetween.toString());
		return findByAgeBetween;

	}

	public List<User> findByAgeLessThanEqual(Integer age) {

		List<User> findByAgeLessThanEqual = dao.findByAgeLessThanEqual(age);
		logger.info("Retrieved user by age less than equal : " + findByAgeLessThanEqual.toString());
		return findByAgeLessThanEqual;
	}

	public List<User> findTop3ByOrderByFirstNameAsc() {

		List<User> findTop3ByOrderByFirstNameAsc = dao.findTop3ByOrderByFirstNameAsc();
		logger.info("Retrieved top 3 user by first name asc  : " + findTop3ByOrderByFirstNameAsc.toString());
		return findTop3ByOrderByFirstNameAsc;

	}

	public List<User> findTop3ByOrderByAgeDesc() {
		List<User> findTop3ByOrderByAgeDesc = dao.findTop3ByOrderByAgeDesc();
		logger.info("Retrieved top 3 user by age desc  : " + findTop3ByOrderByAgeDesc.toString());
		return findTop3ByOrderByAgeDesc;
	}

	public List<String> fetchUsersCountries(User user) {
		List<String> fetchUsersCountries = dao.fetchUsersCountries(user);
		logger.info("User's countries : " + fetchUsersCountries.toString());
		return fetchUsersCountries;
	}

	public List<Integer> fetchUsersPhoneNumbers(User user) {
		List<Integer> fetchUsersPhoneNumbers = dao.fetchUsersPhoneNumbers(user);
		logger.info("User's phone numbers : " + fetchUsersPhoneNumbers.toString());
		return fetchUsersPhoneNumbers;
	}

}
