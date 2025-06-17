package com.example.jpaworkshop.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @ManyToMany(mappedBy = "books") //Mapped indicates that the book is not the owning side
    private List<Author> authors;


    public Book(String title, int maxLoanDays) {
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }

    @PrePersist
    private void onCreation() {
        this.isbn = String.valueOf(UUID.randomUUID());
    }

    public void addAuthor(Author author) {
        if (author == null) throw new IllegalArgumentException("Author cannot be null.");
        if (!this.authors.contains(author)) {
            this.authors.add(author);
            author.addBook(this); // Update the owning side
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
