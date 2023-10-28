package com.bookstore.bookstoreapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstoreapp.entity.MyBookList;

@Repository
public interface MyBookRepo extends JpaRepository<MyBookList,Integer>{
}