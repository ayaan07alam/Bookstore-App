package com.bookstore.bookstoreapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstoreapp.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    
}
