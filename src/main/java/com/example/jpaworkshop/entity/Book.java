package com.example.jpaworkshop.entity;

import jakarta.persistence.*;
import lombok.*;

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

    public Book(String title, int maxLoanDays) {
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }

    @PrePersist
    private void onCreation() {
        this.isbn = String.valueOf(UUID.randomUUID());
    }
}
