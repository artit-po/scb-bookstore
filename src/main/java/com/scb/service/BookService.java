package com.scb.service;

import java.util.List;

import com.scb.exceptions.BookServiceException;
import com.scb.model.Book;

public interface BookService {
	
	public List<Book> getAllBooks() throws BookServiceException;

}
