package com.scb.model.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String name;
	private String surname;
	private String date_of_birth;

}
