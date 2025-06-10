package com.example.jpaworkshop.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)//Makes the colum unique so no duplicates
    private String email;
    private String name;
    private LocalDate birthDate;
}
