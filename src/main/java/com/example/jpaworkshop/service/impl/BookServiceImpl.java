package com.example.jpaworkshop.service.impl;

import com.example.jpaworkshop.dto.BookDTO;
import com.example.jpaworkshop.service.BookService;

import java.util.Optional;

public class BookServiceImpl implements BookService {
    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        return null;
    }

    @Override
    public Optional<BookDTO> findBookById(int id) {
        return Optional.empty();
    }
}
