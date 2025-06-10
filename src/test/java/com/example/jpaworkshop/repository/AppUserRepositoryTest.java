package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.entity.AppUser;
import com.example.jpaworkshop.entity.Details;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //Spring boot annotation to specifically test Jpa repository's
class AppUserRepositoryTest {

    @Autowired // Spring core annotation used for dependency injection to create the bean/instance of field  in the IOC container , can be injected in setter ,field or constructor
    private AppUserRepository appUserRepository;

    private AppUser user1;
    private AppUser user2;
    private AppUser user3;
    private AppUser user4;
    private AppUser user5;

    @BeforeEach // Used to set up things before each test
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


    @Test //Marks it as test
    @DisplayName("Test if user is added to inMemoryDB") //Changes the test name to the one given in the parentheses
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

    @Test
    @DisplayName("Test find users by registration date between")
    public void testFindUsersByRegDateBetween() {
        //Arrange
        LocalDate startDate = LocalDate.now().minusDays(1);
        LocalDate endDate = LocalDate.now().plusDays(1);
        
        //Act
        Collection<AppUser> result = appUserRepository.findAppUserByRegDateBetween(startDate, endDate);
        
        //Assert
        assertEquals(5, result.size());
        assertTrue(result.contains(user1));
        assertTrue(result.contains(user2));
        assertTrue(result.contains(user3));
        assertTrue(result.contains(user4));
        assertTrue(result.contains(user5));
    }

    @Test
    @DisplayName("Test find user by details id")
    public void testFindUserByDetailsId() {
        //Arrange
        AppUser expected = user1;
        int detailsId = user1.getUserDetails().getId();
        
        //Act
        AppUser result = appUserRepository.findAppUsersByUserDetails_Id(detailsId).get();
        
        //Assert
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test find user by details email")
    public void testFindUserByDetailsEmail() {
        //Arrange
        AppUser expected = user2;
        String email = "anna@example.com";
        
        //Act
        AppUser result = appUserRepository.findAppUsersByUserDetails_Email(email).get();
        
        //Assert
        assertNotNull(result);
        assertEquals(expected, result);
        assertEquals(email, result.getUserDetails().getEmail());
    }


    @Test
    @DisplayName("Test find users by registration date between with no results")
    public void testFindUsersByRegDateBetweenNoResults() {
        //Arrange
        LocalDate startDate = LocalDate.now().plusDays(1);
        LocalDate endDate = LocalDate.now().plusDays(2);

        //Act
        Collection<AppUser> result = appUserRepository.findAppUserByRegDateBetween(startDate, endDate);

        //Assert
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test find users by registration date between single day")
    public void testFindUsersByRegDateBetweenSameDay() {
        //Arrange
        LocalDate today = LocalDate.now();

        //Act
        Collection<AppUser> result = appUserRepository.findAppUserByRegDateBetween(today, today);

        //Assert
        assertEquals(5, result.size());
    }

    @Test
    @DisplayName("Test find user by details id when user doesn't exist")
    public void testFindUserByDetailsIdNotFound() {
        //Arrange
        int nonExistentId = 99999;

        //Act & Assert
        assertTrue(appUserRepository.findAppUsersByUserDetails_Id(nonExistentId).isEmpty());
    }

    @Test
    @DisplayName("Test find user by details email with non-existent email")
    public void testFindUserByDetailsEmailNotFound() {
        //Arrange
        String nonExistentEmail = "nonexistent@example.com";

        //Act & Assert
        assertTrue(appUserRepository.findAppUsersByUserDetails_Email(nonExistentEmail).isEmpty());
    }

    @Test
    @DisplayName("Test find user by username with non-existent username")
    public void testFindUserByUsernameNotFound() {
        //Arrange
        String nonExistentUsername = "nonexistentuser";

        //Act & Assert
        assertTrue(appUserRepository.findAppUsersByUsername(nonExistentUsername).isEmpty());
    }

    @Test
    @DisplayName("Test find users by registration date between with reversed dates")
    public void testFindUsersByRegDateBetweenReversedDates() {
        //Arrange
        LocalDate endDate = LocalDate.now().minusDays(1);
        LocalDate startDate = LocalDate.now().plusDays(1);

        //Act
        Collection<AppUser> result = appUserRepository.findAppUserByRegDateBetween(startDate, endDate);

        //Assert
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test case sensitivity of username search")
    public void testFindUserByUsernameCaseSensitive() {
        //Arrange
        String upperCaseUsername = "TEST"; // original is "test"

        //Act
        Optional<AppUser> result = appUserRepository.findAppUsersByUsername(upperCaseUsername);

        //Assert
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test find user by details email case insensitive")
    public void testFindUserByDetailsEmailCaseInsensitive() {
        //Arrange
        String upperCaseEmail = "ANNA@EXAMPLE.COM"; // original is "anna@example.com"

        //Act
        Optional<AppUser> result = appUserRepository.findAppUsersByUserDetails_Email(upperCaseEmail);

        //Assert
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test multiple users with same registration date")
    public void testMultipleUsersWithSameRegDate() {
        //Arrange
        Details newDetails = new Details("new@test.com", "NewUser", LocalDate.of(1995, 1, 1));
        AppUser newUser = new AppUser("newuser", "pass123", LocalDate.now(), newDetails);
        appUserRepository.save(newUser);

        //Act
        Collection<AppUser> result = appUserRepository.findAppUserByRegDateBetween(
                LocalDate.now(), LocalDate.now());

        //Assert
        assertEquals(6, result.size());
        assertTrue(result.contains(newUser));
    }
}

