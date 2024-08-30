package com.demo.service;

import java.util.List;

import com.demo.binding.BookBinding;
import com.demo.entity.Book;

public interface BookService {

	public Book saveBooke(BookBinding bookBinding);
	
	public List<Book> fetchAllBooks();
	
	public Book UpdateBookDetails(BookBinding bookBinding);
	
	public String DeleteBookById(Integer bookId);
	
}
