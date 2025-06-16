package com.example.jpaworkshop.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString

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

    public Book(String title, String isbn, int maxLoanDays) {
        this.title = title;
        this.isbn = isbn;
        this.maxLoanDays = maxLoanDays;
    }
}
