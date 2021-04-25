package com.scb.controller;

import java.math.BigDecimal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scb.exceptions.UserServiceException;
import com.scb.model.request.UserRequest;
import com.scb.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping()
	public ResponseEntity<String> getInformationUsers() {
		return ResponseEntity.ok("");
	}
	
	@DeleteMapping()
	public ResponseEntity<String> deleteInformationUsers() {
		return ResponseEntity.ok("");
	}
	
	@PostMapping()
	public ResponseEntity<String>  createInformationUsers(@Validated @RequestBody UserRequest user) throws UserServiceException {
		userService.createInformationUser(user);
		return ResponseEntity.ok("");
	}
	
	@GetMapping("/orders")
	public ResponseEntity<Map<String, BigDecimal>> getInformationUsersOrders(@RequestParam Integer[] orders) throws UserServiceException {
		Map<String, BigDecimal> map = userService.getInformationUsersOrders(orders);
		return ResponseEntity.ok(map);
	}
	
}
