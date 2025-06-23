package com.example.jpaworkshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@ToString

@Entity
public class BookLoan {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public BookLoan(boolean returned, AppUser borrower, Book book) {
        setBook(book);
        setLoanDate(LocalDate.now());
        calculateDueDate();
        setReturned(returned);
        setBorrower(borrower);
    }

//    @PrePersist
//    private void onCreation() {
//        this.dueDate = getLoanDate().plusDays(getBook().getMaxLoanDays());
//    }

//    @PreUpdate
//    @PreRemove


    private void calculateDueDate() {
        if (book != null && loanDate != null) {
            setDueDate(getLoanDate().plusDays(getBook().getMaxLoanDays()));
        }
    }

}
