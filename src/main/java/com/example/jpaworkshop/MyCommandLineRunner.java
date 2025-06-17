package com.example.jpaworkshop;

import com.example.jpaworkshop.entity.AppUser;
import com.example.jpaworkshop.repository.AppUserRepository;
import com.example.jpaworkshop.repository.BookLoanRepository;
import com.example.jpaworkshop.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    AppUserRepository appUserRepository;
    BookRepository bookRepository;
    BookLoanRepository bookLoanRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

    }
}
