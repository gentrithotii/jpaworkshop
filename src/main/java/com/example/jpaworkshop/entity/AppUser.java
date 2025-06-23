package com.example.jpaworkshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

//Lombok
@NoArgsConstructor // Adds empty constructor which is needed for JPA
@AllArgsConstructor //Adds  a constructor with all arguments
//@Getter  // Add getters to all fields not good to do it to all but since it's a workshop fine
//@Setter //Add Setters to all fields
@ToString // Returns the string of the object
@EqualsAndHashCode //Adds Equals and Hashcode if the objects have same HashCode and are the same

@Entity //Turns this class into Entity which in turn makes it easier by JPA to use it for DB in a relational db
public class AppUser {
    @Getter
    @Id //Marks the id as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // How the generated value behaves
    @Column(updatable = false, name = "app_user_id")
    //Targets the colum here we assigned so it won't update and the name of it
    private int id;

    @Getter
    @Setter
    @Column(nullable = false, unique = true, length = 100)
    //Here We made username unique and the length of it to 100 and not null
    private String username;

    @Getter
    @Setter
    @Column(nullable = false, length = 100) // We won't allow empty password and a length of 100
    private String password;

    @Getter
    @Column(nullable = false, updatable = false) // Won't allow it to be null and updatable = false won't let it change
    private LocalDate regDate;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL) // Adds a relationship one to one
    @JoinColumn(name = "details_id") // Foreign key of details
    private Details userDetails;

    @Getter
    @OneToMany(mappedBy = "borrower")
    List<BookLoan> bookLoans;

    public AppUser(String username, String password, LocalDate regDate, Details userDetails) {
        this.username = username;
        this.password = password;
        this.userDetails = userDetails;
    }

    @PrePersist // Creates the date of now before the entity is Saved
    public void onCreate() {
        this.regDate = LocalDate.now();
    }

}



