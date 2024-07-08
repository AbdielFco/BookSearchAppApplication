package com.example.booksearchapp.controller;

import com.example.booksearchapp.model.Book;
import com.example.booksearchapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    public Book searchBookByTitle(@RequestParam String title) {
        return bookService.findBookByTitle(title);
    }

    @GetMapping
    public List<Book> listAllBooks() {
        return bookService.listAllBooks();
    }
}
