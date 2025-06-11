package com.example.jpaworkshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, name = "details_id")
    @Getter
    private int id;


    @Getter
    @Setter
    @Column(nullable = false, unique = true, length = 70)
    private String email;

    @Getter
    @Setter
    @Column(nullable = false, length = 70)
    private String name;

    @Getter
    @Setter
    private LocalDate birthDate;

    public Details(String email, String name, LocalDate birthDate) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }
}
