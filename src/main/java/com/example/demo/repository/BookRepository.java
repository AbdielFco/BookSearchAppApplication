package com.example.booksearchapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.booksearchapp.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
}
