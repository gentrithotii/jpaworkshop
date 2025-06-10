package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.entity.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    @Query(value = "SELECT au FROM AppUser AS au WHERE au.username = :userName ")
    AppUser findAppUsersByUsername(@Param("userName") String searchName);
}
