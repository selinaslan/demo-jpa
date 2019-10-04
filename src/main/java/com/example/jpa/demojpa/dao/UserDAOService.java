package com.example.jpa.demojpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.jpa.demojpa.entity.User;

@Repository
@Transactional // each method would be involved in a transaction
public class UserDAOService {
	
	@PersistenceContext
	private EntityManager entityManager;;

	public Long insert(User user) {

		entityManager.persist(user);
		return user.getId();
	}

}
