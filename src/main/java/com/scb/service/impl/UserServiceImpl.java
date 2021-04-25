package com.scb.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.entity.UserEntity;
import com.scb.exceptions.UserServiceException;
import com.scb.model.Book;
import com.scb.model.request.UserRequest;
import com.scb.repository.UserRepository;
import com.scb.service.BookService;
import com.scb.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired private BookService bookService;
	
	@Autowired private UserRepository userRepository;
	
	private final String USER = "USER";

	@Override
	public Map<String, BigDecimal> getInformationUsersOrders(Integer[] orders) throws UserServiceException {
		Map<String, BigDecimal> map = new HashedMap<>();
		BigDecimal sumAmount = BigDecimal.ZERO;
		try {
			List<Integer> ids = Arrays.asList(orders);
			List<Book> books = bookService.getAllBooks();
			if (CollectionUtils.isNotEmpty(books)) {
				for (Book book : books) {
					if (ids.contains(book.getId())) {
						sumAmount = sumAmount.add(book.getPrice());
					}
				}
				map.put("price", sumAmount);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserServiceException("getInformationUsersOrders is exceptions", e.getCause());
		}
		return map;
	}

	@Override
	public void createInformationUser(UserRequest user) throws UserServiceException {
		if (ObjectUtils.isNotEmpty(user)) {
			UserEntity entity = new UserEntity(0, user.getUsername(), user.getPassword(), user.getName(), user.getSurname(), user.getDate_of_birth(), USER);
			userRepository.save(entity);
		} else {
			throw new UserServiceException("createInformationUser is exceptions request is Empty");
		}
	}

}
