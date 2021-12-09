package com.E_Commerce.service;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_Commerce.DAO.UserDAO;
import com.E_Commerce.Model.User;

@Service
public class UserService {
	
	@Autowired
	public UserDAO userDAO; 
	
	public User addUser(User user) {
		return userDAO.save(user);
	}
	
	public User verifyUser(String userEmail, String password) {
		
		User user=userDAO.findByuserEmail(userEmail);
		System.out.println(user.getUserPassword());
		System.out.println(password);
		if(user.getUserPassword().equals(password)) {
		return user;
		}
		else {
			return null;
		}
	}

}
