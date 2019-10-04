package com.example.jpa.demojpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.jpa.demojpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByFirstName(String firstName);

	List<User> findByFirstNameOrLastName(String firstName, String lastName);

	List<User> findByAgeBetween(Integer age1, Integer age2);

	List<User> findByAgeLessThanEqual(Integer age);

	List<User> findTop3ByOrderByFirstNameAsc();

	List<User> findTop3ByOrderByAgeDesc();

	@Query("Select ud.country from UserDetail ud where ud.user = ?1  ")
	List<String> fetchUsersCountries(User user);

	@Query("Select ud.phoneNumber from UserDetail ud where ud.user = :userParam")
	List<Integer> fetchUsersPhoneNumbers(@Param("userParam") User user);

}
