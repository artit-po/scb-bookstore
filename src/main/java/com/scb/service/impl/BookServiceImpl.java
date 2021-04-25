package com.scb.service.impl;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.scb.exceptions.BookServiceException;
import com.scb.model.Book;
import com.scb.service.BookService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookServiceImpl implements BookService {

	@Value("${url.scb.books}")
	private String URL_BOOKS;

	@Value("${url.scb.books.recommend}")
	private String URL_BOOKS_RECOMMENDATIONS;
	
	@Value("${rest.client.timeout}")
	private int TIMEOUT;

	@Transactional
	@Override
	public List<Book> getAllBooks() throws BookServiceException {
		List<Book> response = new ArrayList<>();
		response.addAll(getAllBookRecommendations());

		List<Book> books = callSCBApi(URL_BOOKS);
		books.stream().forEach(book -> { if (!response.contains(book)) { response.add(book); } });

		return response;
	}

	private List<Book> getAllBookRecommendations() throws BookServiceException {
		return callSCBApi(URL_BOOKS_RECOMMENDATIONS);
	}

	private List<Book> callSCBApi(String url) throws BookServiceException {
		RestTemplate restTemplate = new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(TIMEOUT)).setReadTimeout(Duration.ofMillis(TIMEOUT)).build();
		ResponseEntity<List<Book>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {});
		return responseEntity.getBody();
	}

}
