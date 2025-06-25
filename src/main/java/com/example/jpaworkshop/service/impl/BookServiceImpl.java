package com.example.jpaworkshop.service.impl;

import com.example.jpaworkshop.dto.BookDTO;
import com.example.jpaworkshop.entity.Book;
import com.example.jpaworkshop.repository.BookRepository;
import com.example.jpaworkshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        Book mappedBook = new Book(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getMaxLoanDays(), bookDTO.isAvailable());
        bookRepository.save(mappedBook);

        return bookDTO;
    }

    @Override
    public Optional<BookDTO> findBookById(int id) {
        Book foundBook = bookRepository.findById(id).orElse(null);
        if (foundBook != null) {
            Optional<BookDTO> bookDTOOptional = Optional.of(new BookDTO(foundBook));
            return bookDTOOptional;
        }
        return Optional.empty();
    }

    @Override
    public Optional<BookDTO> findBookByIsbn(String isbn) {
        return bookRepository.findBooksByIsbnIgnoreCase(isbn).map(book -> new BookDTO(book));
    }

    @Override
    public List<BookDTO> findBookByTitleContains(String title) {
        return bookRepository.findBooksByTitleContains(title).stream().map(book -> new BookDTO(book)).toList();
    }
}
