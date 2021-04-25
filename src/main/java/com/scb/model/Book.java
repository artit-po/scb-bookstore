package com.scb.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private BigDecimal price;
	private String book_name;
	private String author_name;
}
