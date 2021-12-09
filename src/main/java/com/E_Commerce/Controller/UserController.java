package com.E_Commerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.E_Commerce.Exception.UserNotFoundException;
import com.E_Commerce.Model.User;
import com.E_Commerce.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	public UserService userService;

	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User newUser = userService.addUser(user);
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/verify")
	public ResponseEntity<User> verifyUser
	(@RequestParam("userEmail") String userEmail, @RequestParam("userPassword") String  userPassword) throws UserNotFoundException{
		System.out.println(userEmail);
		System.out.println(userPassword);
		User user=userService.verifyUser(userEmail,userPassword);
		System.out.println(user);
		if(user!=null) {
		return new ResponseEntity<>(user,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
		}
	}
	
}
