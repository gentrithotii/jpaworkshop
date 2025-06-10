package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.entity.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    @Query(value = "SELECT au FROM AppUser AS au WHERE au.username = :username ")
    AppUser findAppUsersByUsername(@Param("username") String searchName);

///    @Query(value = "SELECT au FROM AppUser  as au WHERE au.regDate = :regDate AND local date BETWEEN  au.regDate AND :toDate ")
///   Collection<AppUser> findAppUserByRegDateBetween(@Param("regDate") LocalDate fromDate,@Param("toDate") LocalDate toDate);


    Collection<AppUser> findAppUserByRegDateBetween(LocalDate regDateAfter, LocalDate regDateBefore);

    AppUser findAppUserByUserDetails_Id(int userDetailsId);

    AppUser findAppUsersByUserDetails_Email(String userDetailsEmail);
}
