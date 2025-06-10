package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.entity.Details;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DetailsRepositoryTest {
    @Autowired
    private DetailsRepository detailsRepository;

    private Details details1;
    private Details details2;
    private Details details3;
    private Details details4;
    private Details details5;

    @BeforeEach
    public void setUp() {
        details1 = new Details("test@test.com", "John", LocalDate.of(1994, 10, 24));
        details2 = new Details("anna@example.com", "John", LocalDate.of(1988, 5, 12));
        details3 = new Details("john@mail.com", "JOHN", LocalDate.of(2000, 1, 5));
        details4 = new Details("maria@example.org", "Maria", LocalDate.of(1990, 7, 19));
        details5 = new Details("alex@test.com", "Alex", LocalDate.of(1999, 12, 30));

        detailsRepository.save(details1);
        detailsRepository.save(details2);
        detailsRepository.save(details3);
        detailsRepository.save(details4);
        detailsRepository.save(details5);
    }

    @Test
    @DisplayName("Test if details is added to inMemoryDB")
    public void testIfDetailsAdded() {
        //Arrange
        Details expected = new Details("create@create.com", "Creator", LocalDate.of(2000, 10, 24));

        //Act
        detailsRepository.save(expected);
        Details result = detailsRepository.findById(expected.getId()).get();

        //Assert
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test find details by email")
    public void testFindDetailsByEmail() {
        //Arrange
        Details expected = details1;
        String email = "test@test.com";

        //Act
        Details result = detailsRepository.findDetailsByEmail(email).get();

        //Assert
        assertEquals(expected, result);
        assertEquals(email, result.getEmail());
    }

    @Test
    @DisplayName("Test find details by email not found")
    public void testFindDetailsByEmailNotFound() {
        //Arrange
        String nonExistentEmail = "notfound@test.com";

        //Act & Assert
        assertTrue(detailsRepository.findDetailsByEmail(nonExistentEmail).isEmpty());
    }

    @Test
    @DisplayName("Test find details by name")
    public void testFindDetailsByName() {
        //Arrange
        String name = "John";

        //Act
        Collection<Details> result = detailsRepository.findDetailsByName(name);

        //Assert
        assertEquals(2, result.size());
        assertTrue(result.contains(details1));
        assertTrue(result.contains(details2));
    }

    @Test
    @DisplayName("Test find details by name case sensitive")
    public void testFindDetailsByNameCaseSensitive() {
        //Arrange
        String name = "JOHN";

        //Act
        Collection<Details> result = detailsRepository.findDetailsByName(name);

        //Assert
        assertEquals(1, result.size());
        assertTrue(result.contains(details3));
    }

    @Test
    @DisplayName("Test find details by name ignore case")
    public void testFindDetailsByNameIgnoreCase() {
        //Arrange
        String name = "john";

        //Act
        Collection<Details> result = detailsRepository.findDetailsByNameIgnoreCase(name);

        //Assert
        assertEquals(3, result.size());
        assertTrue(result.contains(details1));
        assertTrue(result.contains(details2));
        assertTrue(result.contains(details3));
    }

    @Test
    @DisplayName("Test find details by name not found")
    public void testFindDetailsByNameNotFound() {
        //Arrange
        String nonExistentName = "NonExistent";

        //Act
        Collection<Details> result = detailsRepository.findDetailsByName(nonExistentName);

        //Assert
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test find details by name ignore case with mixed case input")
    public void testFindDetailsByNameIgnoreCaseMixedCase() {
        //Arrange
        String mixedCaseName = "jOhN";

        //Act
        Collection<Details> result = detailsRepository.findDetailsByNameIgnoreCase(mixedCaseName);

        //Assert
        assertEquals(3, result.size());
        assertTrue(result.contains(details1));
        assertTrue(result.contains(details2));
        assertTrue(result.contains(details3));
    }

    @Test
    @DisplayName("Test unique email constraint")
    public void testUniqueEmailConstraint() {
        //Arrange
        Details detailsWithDuplicateEmail = new Details("test@test.com", "Another John", LocalDate.of(1995, 1, 1));

        //Act & Assert
        assertThrows(Exception.class, () -> detailsRepository.save(detailsWithDuplicateEmail));
    }

    @Test
    @DisplayName("Test find details by name with single result")
    public void testFindDetailsByNameSingleResult() {
        //Arrange
        String uniqueName = "Maria";

        //Act
        Collection<Details> result = detailsRepository.findDetailsByName(uniqueName);

        //Assert
        assertEquals(1, result.size());
        assertTrue(result.contains(details4));
    }
}