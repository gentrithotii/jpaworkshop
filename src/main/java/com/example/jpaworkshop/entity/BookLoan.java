package com.example.jpaworkshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Column(nullable = false, updatable = false)
    private int id;
    @Getter
    @Setter
    @Column(nullable = false)
    private LocalDate loanDate;
    @Getter
    @Setter
    @Column(nullable = false)
    private LocalDate dueDate;

    @Getter
    @Setter
    private boolean returned;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser borrower;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public BookLoan(LocalDate loanDate, LocalDate dueDate, boolean returned, AppUser borrower, Book book) {
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = returned;
        this.borrower = borrower;
        this.book = book;
    }

    public void loanBook(Book book) {
        setLoanDate(LocalDate.now());
        setDueDate(LocalDate.now().plusDays(book.getMaxLoanDays()));
        // setReturned(false);
        setBook(book);

    }
}
