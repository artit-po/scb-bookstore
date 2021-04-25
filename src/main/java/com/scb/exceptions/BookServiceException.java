package com.scb.exceptions;

import lombok.Getter;
import lombok.Setter;

public class BookServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private String message;

	public BookServiceException() {
		super();
	}

	public BookServiceException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public BookServiceException(String message) {
		super(message);
		this.message = message;
	}

	public BookServiceException(Throwable cause) {
		super(cause);
	}	
	
}
