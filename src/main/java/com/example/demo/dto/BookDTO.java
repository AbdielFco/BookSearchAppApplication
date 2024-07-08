package com.example.booksearchapp.dto;

import java.util.List;

public class BookDTO {
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public static class Result {
        private String title;
        private List<Author> authors;
        private List<String> languages;
        private int downloadCount;

        // Getters y setters

        public static class Author {
            private String lastName;
            private String firstName;

            // Getters y setters
        }
    }
}
