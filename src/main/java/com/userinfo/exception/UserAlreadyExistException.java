package com.userinfo.exception;

public class UserAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String message;


	public UserAlreadyExistException(String message) {
		super();
		this.message = message;
	}


	public UserAlreadyExistException() {
		super();
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
