package com.example.jpaworkshop.service.impl;

import com.example.jpaworkshop.repository.BookLoanRepository;
import com.example.jpaworkshop.service.BookLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLoanServiceImpl implements BookLoanService {
    private BookLoanRepository bookLoanRepository;


    @Autowired
    public BookLoanServiceImpl(BookLoanRepository bookLoanRepository) {
        this.bookLoanRepository = bookLoanRepository;
    }
}
