package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.entity.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Repository //Marks this interface as a repository that will handle crud operations is not needed but good to use
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    Optional<AppUser> findAppUsersByUsername(String username);

    Collection<AppUser> findAppUserByRegDateBetween(LocalDate regDateAfter, LocalDate regDateBefore);

    Optional<AppUser> findAppUserByUserDetails_Id(int id);

    Optional<AppUser> findAppUserByUserDetails_Email(String userDetailsEmail);
}
