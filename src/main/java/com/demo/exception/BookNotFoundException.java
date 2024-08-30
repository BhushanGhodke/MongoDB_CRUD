package com.demo.exception;

import org.springframework.stereotype.Component;

@Component
public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(String msg) {
	
		super(msg);
	}
	
	public BookNotFoundException() {
		
	}
}
