package com.example.booksearchapp.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String authorLastName;
    private String authorFirstName;
    private String language;
    private int downloadCount;

    // Getters y setters
}
