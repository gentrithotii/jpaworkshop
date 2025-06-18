package com.example.jpaworkshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int id;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;


    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books = new HashSet<>();

    public void addBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null.");
        if (!this.books.contains(book)) {
            this.books.add(book);

            if (book.getAuthors() != null && !book.getAuthors().contains(this)) {
                book.addAuthor(this);
            }
        }
    }

    public void removeBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null.");
        if (this.books.contains(book)) {
            this.books.remove(book);

            if (book.getAuthors() != null && book.getAuthors().contains(this)) {
                book.removeAuthor(this);
            }
        }
    }

}
