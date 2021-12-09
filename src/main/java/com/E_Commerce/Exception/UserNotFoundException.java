package com.E_Commerce.Exception;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String s) {
		super(s);
	}
}