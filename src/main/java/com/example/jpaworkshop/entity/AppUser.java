package com.example.jpaworkshop.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity //
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;
    private String password;
    private LocalDate regDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private Details userDetails;
}
