package com.rs.exceptions;

public class UserDoesNotExistException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public UserDoesNotExistException() {
		super("User tried logging in with credentials that doesn't exist");
	}

}
