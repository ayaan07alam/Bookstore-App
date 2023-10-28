package com.bookstore.bookstoreapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstoreapp.entity.MyBookList;
import com.bookstore.bookstoreapp.repository.MyBookRepo;

@Service
public class MyBookListService {

    @Autowired
    private MyBookRepo myBook;

    public void saveMyBooks(MyBookList book) {
        myBook.save(book);

    }

    public List<MyBookList> getAllMyBooks(){
        return myBook.findAll();
    }

    public void deleteById(int id){
        myBook.deleteById(id);
    }
}
