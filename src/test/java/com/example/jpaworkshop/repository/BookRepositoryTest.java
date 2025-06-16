package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.entity.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    private Book setUpBook1;
    private Book setUpBook2;
    private Book setUpBook3;
    private Book setUpBook4;
    private Book setUpBook5;
    private Book setUpBook6;
    private Book setUpBook7;
    private Book setUpBook8;
    private Book setUpBook9;

    @BeforeEach
    void setUp() {
        setUpBook1 = new Book("The Book of the Fallen King of Rats", 52);
        setUpBook2 = new Book("The Hitchhiker's Guide to the Galaxy", 30);
        setUpBook3 = new Book("Pride and Prejudice", 21);
        setUpBook4 = new Book("Dune", 45);
        setUpBook5 = new Book("To Kill a Mockingbird", 28);
        setUpBook6 = new Book("1984", 21);
        setUpBook7 = new Book("The Great Gatsby", 14);
        setUpBook8 = new Book("Moby Dick", 60);
        setUpBook9 = new Book("War and Peace", 90);

        bookRepository.saveAll(Arrays.asList(
                setUpBook1, setUpBook2, setUpBook3, setUpBook4, setUpBook5,
                setUpBook6, setUpBook7, setUpBook8, setUpBook9
        ));
    }

    @AfterEach
    void tearDown() {
        bookRepository.deleteAll();
    }

    @Test
    @DisplayName("Find book by ISBN ignoring case")
    void findBooksByIsbnIgnoreCase() {
        // Arrange
        Book book = new Book("Special ISBN Book", 40);
        Book savedBook = bookRepository.save(book); // triggers @PrePersist

        String generatedIsbn = savedBook.getIsbn();

        // Act
        Optional<Book> result = bookRepository.findBooksByIsbnIgnoreCase(generatedIsbn.toLowerCase());

        // Assert
        assertTrue(result.isPresent());
        assertEquals(savedBook.getTitle(), result.get().getTitle());
        assertEquals(generatedIsbn, result.get().getIsbn());
    }

    @Test
    @DisplayName("Find book by the title contains")
    void findBooksByTitleContains() {
        // Arrange
        Book duneBook1 = new Book("Dune of the elements 52", 86);
        Book duneBook2 = new Book("Monkey of Dune 52", 90);
        Book duneBook3 = new Book("The 1000 moons and their Dune", 52);

        bookRepository.saveAll(Arrays.asList(duneBook1, duneBook2, duneBook3));

        // Act
        List<Book> result = bookRepository.findBooksByTitleContains("Dune");
        List<Book> expected = new ArrayList<>(Arrays.asList(duneBook1, duneBook2, duneBook3, setUpBook4));

        // Assert
        assertEquals(new HashSet<>(expected), new HashSet<>(result));
    }

    @Test
    @DisplayName("Test Get books by exact max loan days")
    void findBooksByMaxLoanDays() {
        // Arrange
        Book book1 = new Book("Book1 with maxLoanDays 1001", 1001);
        Book book2 = new Book("Book2 with maxLoanDays 1001", 1001);
        Book book3 = new Book("Book3 with maxLoanDays 1001", 1001);
        Book book4 = new Book("Book4 with maxLoanDays 32", 32);
        Book book5 = new Book("Book5 with maxLoanDays 32", 32);
        Book book6 = new Book("Book6 with maxLoanDays 1001", 1001);

        bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5, book6));

        // Act
        List<Book> resultList = bookRepository.findBooksByMaxLoanDays(1001);

        // Assert
        List<Book> expectedList = List.of(book1, book2, book3, book6);
        assertEquals(expectedList, resultList);
    }

    @Test
    @DisplayName("Return empty list when no books match title search")
    void findBooksByTitleContains_NoMatch() {
        // Act
        List<Book> result = bookRepository.findBooksByTitleContains("ThisTitleDoesNotExist");

        // Assert
        assertTrue(result.isEmpty());
    }
}
