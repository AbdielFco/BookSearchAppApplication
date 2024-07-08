package com.example.booksearchapp.model;

import javax.persistence.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private int birthYear;
    private int deathYear;

    // Getters y setters
}
