package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.entity.AppUser;
import com.example.jpaworkshop.entity.Details;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;

    private AppUser user1;
    private AppUser user2;
    private AppUser user3;
    private AppUser user4;
    private AppUser user5;

    @BeforeEach
    public void setUp() {
        Details detailsUser1 = new Details("test@test.com", "Gentrit", LocalDate.of(1994, 10, 24));
        user1 = new AppUser("test", "1234", LocalDate.now(), detailsUser1);

        Details detailsUser2 = new Details("anna@example.com", "Anna", LocalDate.of(1988, 5, 12));
        user2 = new AppUser("anna88", "abcd", LocalDate.now(), detailsUser2);

        Details detailsUser3 = new Details("johndoe@mail.com", "John", LocalDate.of(2000, 1, 5));
        user3 = new AppUser("johnd", "pass123", LocalDate.now(), detailsUser3);

        Details detailsUser4 = new Details("maria@example.org", "Maria", LocalDate.of(1990, 7, 19));
        user4 = new AppUser("maria90", "secure!", LocalDate.now(), detailsUser4);

        Details detailsUser5 = new Details("alex99@test.com", "Alex", LocalDate.of(1999, 12, 30));
        user5 = new AppUser("alex99", "mypassword", LocalDate.now(), detailsUser5);

        appUserRepository.save(user1);
        appUserRepository.save(user2);
        appUserRepository.save(user3);
        appUserRepository.save(user4);
        appUserRepository.save(user5);

    }


    @Test
    @DisplayName("Test if user is added to inMemoryDB")
    public void testIfUserAdded() {
        //Arrange
        Details detailsUser = new Details("create@create.com", "creator", LocalDate.of(2000, 10, 24));
        AppUser expected = new AppUser("create", "2345", LocalDate.now(), detailsUser);

        //Act
        appUserRepository.save(expected);
        AppUser result = appUserRepository.findById(expected.getId()).get();

        //Assert
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test find by Username ")
    public void testIfUserFound() {
        //Arrange
        AppUser expected = user1;
        //Act
        AppUser result = appUserRepository.findAppUsersByUsername("test").get();
        //Assert
        assertEquals(expected, result);
    }


}