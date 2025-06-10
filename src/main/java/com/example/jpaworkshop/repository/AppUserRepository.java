package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.entity.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    Optional<AppUser> findAppUsersByUsername(String username);

    Collection<AppUser> findAppUserByRegDateBetween(LocalDate regDateAfter, LocalDate regDateBefore);

    Optional<AppUser> findAppUsersByUserDetails_Id(int id);

    Optional<AppUser> findAppUsersByUserDetails_Email(String userDetailsEmail);
}
