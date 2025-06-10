package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.entity.Details;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface DetailsRepository extends CrudRepository<Details, Integer> {

    Optional<Details> findDetailsByEmail(String email);

    Collection<Details> findDetailsByName(String name);

    Collection<Details> findDetailsByNameIgnoreCase(String name);

}
