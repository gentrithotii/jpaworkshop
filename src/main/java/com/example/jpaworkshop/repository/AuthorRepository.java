package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.entity.Author;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

    Optional<Author> findAuthorByFirstName(String firstName);

    Optional<Author> findAuthorByLastName(String lastName);

    @Query(value = "SELECT a FROM Author AS a WHERE  a.firstName LIKE %:keyword% OR a.lastName LIKE %:keyword%")
    List<Author> findAuthorsByFirstNameOrLastNameIsContaining(@Param("keyword") String keyword);

    @Query("SELECT a FROM Author AS a JOIN a.books AS b WHERE b.id = :id")
    List<Author> findAuthorsByBook_Id(@Param("id") int id);

    @Query("UPDATE Author a SET a.firstName = :updateName  WHERE a.id = :author_id")
    @Modifying
    Optional<Author> updateAuthorNameById(@Param("author_id") int id, @Param("updateName") String firstName);

    Optional<Author> deleteAuthorById(int id);

}
