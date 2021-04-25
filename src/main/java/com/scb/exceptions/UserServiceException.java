package com.scb.exceptions;

import lombok.Getter;
import lombok.Setter;

public class UserServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private String message;

	public UserServiceException() {
		super();
	}

	public UserServiceException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public UserServiceException(String message) {
		super(message);
		this.message = message;
	}

	public UserServiceException(Throwable cause) {
		super(cause);
		this.message = message;
	}
	

}
