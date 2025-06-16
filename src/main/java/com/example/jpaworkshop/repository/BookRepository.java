package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    Optional<Book> findBooksByIsbnIgnoreCase(String isbn);

    List<Book> findBooksByTitleContains(String title);

    List<Book> findBooksByMaxLoanDays(int maxLoanDays);
}
