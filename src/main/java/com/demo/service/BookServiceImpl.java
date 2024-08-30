package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.binding.BookBinding;
import com.demo.entity.Book;
import com.demo.exception.BookNotFoundException;
import com.demo.repository.BookRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book saveBooke(BookBinding bookBinding) {
	
		Book book = new Book();
		BeanUtils.copyProperties(bookBinding, book);
		Book savedBook = bookRepository.save(book);
		return savedBook;
	}

	@Override
	public List<Book> fetchAllBooks() {
		
		List<Book> bookList = bookRepository.findAll();
		return bookList;
	}

	@Override
	public Book UpdateBookDetails(BookBinding bookBinding) {
		Book book = bookRepository.findById(bookBinding.getId()).orElseThrow(
				()->new BookNotFoundException("Book with "+bookBinding.getId() +" id not exist in database"));
		
		BeanUtils.copyProperties(bookBinding, book);
		Book savedBook = bookRepository.save(book);
		
		return savedBook;
	}

	@Override
	public String DeleteBookById(Integer bookId) {
	
		bookRepository.findById(bookId).orElseThrow(()->
			 new BookNotFoundException("Book with "+ bookId +" id not exist in database"));
		
		bookRepository.deleteById(bookId);
		
		return "Book Deleted id :: " +bookId ;
	}

	
}
