package com.example.jpaworkshop.service;

import com.example.jpaworkshop.repository.BookLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLoanService {
    private BookLoanRepository bookLoanRepository;


    @Autowired
    public BookLoanService(BookLoanRepository bookLoanRepository) {
        this.bookLoanRepository = bookLoanRepository;
    }
}
