package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.entity.AppUser;
import com.example.jpaworkshop.entity.Details;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AppUserRepositoryTest {
    @Autowired
    private AppUserRepository appUserRepository;


    @Test
    public void testIfUserAdded() {
        Details detailsUser = new Details("test@test.com", "Gentrit", LocalDate.of(1994, 10, 24));
        AppUser expected = new AppUser("test", "1234", LocalDate.now(), detailsUser);

        appUserRepository.save(expected);
        AppUser result = appUserRepository.findById(expected.getId()).orElse(null);
        assertEquals(expected, result);
    }
}