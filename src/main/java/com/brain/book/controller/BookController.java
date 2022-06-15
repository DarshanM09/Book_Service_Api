package com.brain.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brain.book.Entity.Book;
import com.brain.book.Repository.BookRepo;
import com.brain.book.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	
	@Autowired
	private BookService bookService;
	
	
	
	@PostMapping("/create")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		
		Book createBook = this.bookService.createBook(book);
		
	
		
		return new ResponseEntity<Book>(createBook,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update/{bookId}")
	public ResponseEntity<Book> UpdateBooks(@RequestBody Book book ,@PathVariable Integer bookId){
		
		Book updateBook = bookService.UpdateBook(book, bookId);
		
	
		
	
		
		return new ResponseEntity<Book>(updateBook,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Book>> getAllBook(){
		
		List<Book> allBook = this.bookService.getAllBook();
		
	
		
		
		return new ResponseEntity<List<Book>>(allBook,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/get/{bookId}")
	public ResponseEntity<Book> getAllBook(@PathVariable Integer bookId){
		
		Book getsingleBookById = this.bookService.getsingleBookById(bookId);
		
	
		
		
		return new ResponseEntity<Book>(getsingleBookById,HttpStatus.OK);
		
		
	}
	
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<ApiResponse> deleteBook(@PathVariable Integer bookId){
		
		this.bookService.deleteBook(bookId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("book deleted Sucessfully..!!",true),HttpStatus.OK);
		
		
	}
	
}
