package com.practicas.dao;

import java.util.List;

import com.practicas.model.User;


public interface UserDao {

	User findById(int id);
	
	User findByEmail(String email);
	
	void save(User user);
	
	void deleteByEmail(String email);
	
	List<User> findAllUsers();
	
}

