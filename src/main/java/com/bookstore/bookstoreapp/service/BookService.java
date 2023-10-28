package com.bookstore.bookstoreapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstoreapp.entity.Book;
import com.bookstore.bookstoreapp.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bRepo;
    public void save(Book b){
        // logic to save book in database
        bRepo.save(b);

    };

    public List<Book> getAllBooks(){
        return bRepo.findAll();
    }
    
    public Book getBookById(int id){
        return bRepo.findById(id).get();
    }

    public void deleteById(int id){
        bRepo.deleteById(id);
    }
}
