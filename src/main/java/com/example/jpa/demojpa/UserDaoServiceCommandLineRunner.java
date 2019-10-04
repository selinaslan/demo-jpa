package com.example.jpa.demojpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.jpa.demojpa.dao.UserDAOService;
import com.example.jpa.demojpa.entity.User;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

	@Autowired
	private UserDAOService dao;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Selin", "Aslan",27,"Admin");
		long insert = dao.insert(user);
		logger.info("New user inserted :" + insert);
	}

}
