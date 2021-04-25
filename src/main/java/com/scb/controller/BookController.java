package com.scb.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.exceptions.BookServiceException;
import com.scb.model.Book;
import com.scb.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() throws BookServiceException {
		List<Book> books = bookService.getAllBooks();
		if (CollectionUtils.isNotEmpty(books)) {
			return ResponseEntity.ok(books);
		}
		return ResponseEntity.ok(new ArrayList<>());
	}

}
