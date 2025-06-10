package com.example.jpaworkshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, name = "details_id")
    private int id;

    @Column(nullable = false, unique = true, length = 70)
    private String email;

    @Column(nullable = false, length = 70)
    private String name;

    private LocalDate birthDate;

    public Details(String email, String name, LocalDate birthDate) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }
}
