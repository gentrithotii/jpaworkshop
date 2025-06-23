package com.example.jpaworkshop.service.impl;

import com.example.jpaworkshop.repository.AppUserRepository;
import com.example.jpaworkshop.repository.BookLoanRepository;
import com.example.jpaworkshop.service.BookManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookManagerServiceImpl implements BookManagerService {
    private final AppUserRepository appUserRepository;
    private final BookLoanRepository bookLoanRepository;

    @Autowired
    public BookManagerServiceImpl(AppUserRepository appUserRepository, BookLoanRepository bookLoanRepository) {
        this.appUserRepository = appUserRepository;
        this.bookLoanRepository = bookLoanRepository;
    }
}
