package com.scb.service;

import java.math.BigDecimal;
import java.util.Map;

import com.scb.exceptions.UserServiceException;
import com.scb.model.request.UserRequest;

public interface UserService {
	
	public Map<String, BigDecimal> getInformationUsersOrders(Integer[] orders) throws UserServiceException;
	
	public void createInformationUser(UserRequest user) throws UserServiceException;

}
