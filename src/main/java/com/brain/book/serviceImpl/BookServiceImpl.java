package com.brain.book.serviceImpl;

import java.util.List;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brain.book.Entity.Book;
import com.brain.book.Exception.ResourceNotFoundException;
import com.brain.book.Repository.BookRepo;
import com.brain.book.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	
	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public Book createBook(Book book) {


		Book save = this.bookRepo.save(book);
		
		
		return save;
	}

	@Override
	public Book UpdateBook(Book book, Integer bookId) {


		 Book book2 = this.bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", bookId));	
		
		 book2.setBookName(book.getBookName());
		 book2.setPrice(book.getPrice());
		 
		 Book save = this.bookRepo.save(book2);
		
		
		
		
		return save;
	}

	@Override
	public void deleteBook(Integer bookId) {


		 Book book2 = this.bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", bookId));
		
		 this.bookRepo.delete(book2);
		
	}

	@Override
	public List<Book> getAllBook() {


		List<Book> bookList = this.bookRepo.findAll();
		
		List<Book> collect = bookList.stream().map(list1 ->(list1)).collect(Collectors.toList());
		
		
		
		return collect;
	}

	@Override
	public Book getsingleBookById(Integer bookId) {


		 Book book2 = this.bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", bookId));
			
		
		
		return book2;
	}

}
