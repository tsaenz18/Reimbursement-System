package com.rs.exceptions;

public class EmailAlreadyRegisteredException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EmailAlreadyRegisteredException() {
		super("That Email Is Already Registered");
	}
	
}