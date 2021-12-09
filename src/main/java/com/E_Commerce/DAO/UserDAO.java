package com.E_Commerce.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.E_Commerce.Model.User;

public interface UserDAO extends JpaRepository<User, Integer>{
	
	public User findByuserEmail(String userEmail);

}
