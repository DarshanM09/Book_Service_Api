package com.brain.book.service;

import java.util.List;

import com.brain.book.Entity.Book;

public interface BookService {

	// create book
	Book createBook(Book book);

	// update Book
	Book UpdateBook(Book book, Integer bookId);

	// delete Book
	void deleteBook(Integer bookId);

	// all books
	List<Book> getAllBook();

	// get single Book

	Book getsingleBookById(Integer bookId);

}
