package com.example.jpaworkshop.dto;

import com.example.jpaworkshop.entity.Author;
import com.example.jpaworkshop.entity.Book;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    @Setter(AccessLevel.NONE)
    private int id;
    private String isbn;
    private String title;
    private int maxLoanDays;
    private boolean isAvailable;

    public BookDTO(Book book) {
        setIsbn(book.getIsbn());
        setTitle(book.getTitle());
        setMaxLoanDays(book.getMaxLoanDays());
        setAvailable(book.isAvailable());
    }

}
