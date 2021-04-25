package com.scb.model.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "username is mandatory")
	private String username;
	
	@NotBlank(message = "username is mandatory")
	private String password;
}
