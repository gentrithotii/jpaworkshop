package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.entity.Details;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends CrudRepository<Details, Integer> {
    //Find by email
    //Find by name contains
    //Find by name ignore-case

}
