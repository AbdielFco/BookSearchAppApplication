package com.example.booksearchapp.service;

import com.example.booksearchapp.model.Book;
import com.example.booksearchapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.booksearchapp.dto.BookDTO;
import com.example.booksearchapp.exception.BookNotFoundException;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_URL = "https://gutendex.com/books?search=";

    public Book findBookByTitle(String title) {
        Book existingBook = bookRepository.findByTitle(title);
        if (existingBook != null) {
            return existingBook;
        }

        BookDTO bookDTO = restTemplate.getForObject(API_URL + title, BookDTO.class);

        if (bookDTO == null || bookDTO.getResults().isEmpty()) {
            throw new BookNotFoundException("Book not found");
        }

        Book book = new Book();
        book.setTitle(bookDTO.getResults().get(0).getTitle());
        book.setAuthorLastName(bookDTO.getResults().get(0).getAuthors().get(0).getLastName());
        book.setAuthorFirstName(bookDTO.getResults().get(0).getAuthors().get(0).getFirstName());
        book.setLanguage(bookDTO.getResults().get(0).getLanguages().get(0));
        book.setDownloadCount(bookDTO.getResults().get(0).getDownloadCount());

        return bookRepository.save(book);
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }
}
