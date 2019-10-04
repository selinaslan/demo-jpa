package com.example.jpa.demojpa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.jpa.demojpa.entity.User;
import com.example.jpa.demojpa.entity.UserDetail;
import com.example.jpa.demojpa.service.DemoJPAService;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

	@Autowired
	private DemoJPAService service;

	@Override
	public void run(String... args) throws Exception {
		UserDetail userDetail = new UserDetail("US", "109 Hollywood Avenue", 123456);
		UserDetail userDetail3 = new UserDetail("TR", "421 Temple Street", 222222);
		UserDetail userDetail4 = new UserDetail("AB", "55 Storrs Road", 333333);
		UserDetail userDetail5 = new UserDetail("FA", "123 Main Street", 444444);
		UserDetail userDetail6 = new UserDetail("EDS", "345 Laramie Ave", 555555);
		UserDetail userDetail7 = new UserDetail("LL", "Phonex St", 666666);
		UserDetail userDetail8 = new UserDetail("TR", "88 Corner Street", 777777);

		User user = service.save(new User("Hakan", "Akgunes", 32, "User", userDetail));
		User user2 = service.save(new User("Sinem", "Aslan Kan", 36, "User", userDetail3));
		User user3 = service.save(new User("Anil", "Demir", 37, "User", userDetail4, userDetail5));
		User user4 = service.save(new User("Nese", "Ak", 54, "User", userDetail6));
		User user5 = service.save(new User("Merve", "Kaplan", 63, "User", userDetail7, userDetail8));

		UserDetail userDetail2 = new UserDetail("US", "1 Microsoft Way", 111111);

		User findById = service.findById(1L);

		List<User> findAll = service.findAll();

		User findByFirstName = service.findByFirstName("Hakan");

		List<User> findByFirstNameOrLastName = service.findByFirstNameOrLastName("Selin", "Akgunes");

		List<User> findByAgeBetween = service.findByAgeBetween(30, 40);

		List<User> findByAgeLessThanEqual = service.findByAgeLessThanEqual(27);

		List<User> findTop3ByOrderByFirstNameAsc = service.findTop3ByOrderByFirstNameAsc();

		List<User> findTop3ByOrderByAgeDesc = service.findTop3ByOrderByAgeDesc();
		
		List<String> fetchUsersCountries = service.fetchUsersCountries(user3);
		
		List<Integer> fetchUsersPhoneNumbers = service.fetchUsersPhoneNumbers(user5);
	}

}
