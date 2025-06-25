package com.example.jpaworkshop.service;

import com.example.jpaworkshop.dto.BookDTO;
import com.example.jpaworkshop.entity.Book;
import com.example.jpaworkshop.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    BookDTO addBook(BookDTO bookDTO);

    Optional<BookDTO> findBookById(int id);

    Optional<BookDTO> findBookByIsbn(String isbn);

    List<BookDTO> findBookByTitleContains(String title);
}
