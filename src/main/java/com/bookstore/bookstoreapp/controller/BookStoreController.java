package com.bookstore.bookstoreapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.bookstore.bookstoreapp.entity.Book;
import com.bookstore.bookstoreapp.entity.MyBookList;
import com.bookstore.bookstoreapp.service.BookService;
import com.bookstore.bookstoreapp.service.MyBookListService;

@Controller
public class BookStoreController {

    @Autowired
    private BookService service;

    @Autowired
    private MyBookListService myBookService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegisterForm() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAvailableBooks() {

        List<Book> list = service.getAllBooks();
        // THEY ARE THE ALTERNATE METHODS
        // ModelAndView m = new ModelAndView();
        // m.setViewName("bookList");
        // m.addObject("book", list);
        // return m;

        return new ModelAndView("bookList", "book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        // save the book to database here
        service.save(b);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model) {

        List<MyBookList> list = myBookService.getAllMyBooks();
        model.addAttribute("book", list);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b = service.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {

        Book b = service.getBookById(id);
        model.addAttribute("book", b);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/available_books";
}
}