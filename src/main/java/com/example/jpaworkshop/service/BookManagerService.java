package com.example.jpaworkshop.service;

import com.example.jpaworkshop.repository.AppUserRepository;
import com.example.jpaworkshop.repository.BookLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookManagerService {
    private AppUserRepository appUserRepository;
    private BookLoanRepository bookLoanRepository;

    @Autowired
    public BookManagerService(AppUserRepository appUserRepository, BookLoanRepository bookLoanRepository) {
        this.appUserRepository = appUserRepository;
        this.bookLoanRepository = bookLoanRepository;
    }
}
