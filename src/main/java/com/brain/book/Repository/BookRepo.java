package com.brain.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brain.book.Entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
