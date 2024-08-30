package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.demo.binding.BookBinding;
import com.demo.entity.Book;
import com.demo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/save")
	public ResponseEntity<Book> saveBook(@RequestBody BookBinding bookBinding) {

		Book book = bookService.saveBooke(bookBinding);

		return new ResponseEntity<Book>(book, HttpStatus.CREATED);
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<List<Book>> getAllBooks() {

		List<Book> bookList = bookService.fetchAllBooks();

		return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/update")
	public Book updateBookDetails(@RequestBody BookBinding bookBinding) {

		Book book = bookService.UpdateBookDetails(bookBinding);

		return book;
	}

	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public String deleteBookById(@PathVariable Integer id) {
		String msg = bookService.DeleteBookById(id);

		return msg;
	}
}
