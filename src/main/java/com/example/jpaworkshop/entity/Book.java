package com.example.jpaworkshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Column(nullable = false, name = "book_id", updatable = false)
    private int id;

    @Getter
    @Column(unique = true, nullable = false)
    private String isbn;

    @Getter
    @Setter
    @Column(nullable = false)
    private String title;

    @Getter
    @Setter
    @Column(nullable = false)
    private int maxLoanDays;

    @Getter
    @Setter
    private boolean isAvailable;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "books") //Mapped indicates that the book is not the owning side
    private List<Author> authors = new ArrayList<>();

    public Book(String isbn, String title, int maxLoanDays, List<Author> authors) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
        this.authors = authors;
    }

    public Book(String isbn, String title, int maxLoanDays, boolean isAvailable) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
        this.isAvailable = isAvailable;
    }

    public Book(String title, int maxLoanDays) {
        this.title = title;
        this.maxLoanDays = maxLoanDays;
        this.isbn = String.valueOf(UUID.randomUUID());
        this.isAvailable = true;
    }


    public void addAuthor(Author author) {
        if (author == null) throw new IllegalArgumentException("Author cannot be null.");
        if (!this.authors.contains(author)) {
            this.authors.add(author);
            author.addBook(this);
        }
    }

    public void removeAuthor(Author author) {
        if (author == null) throw new IllegalArgumentException("Author cannot be null.");
        if (this.authors.contains(author)) {
            this.authors.remove(author);
            author.removeBook(this);
        }
    }

}
