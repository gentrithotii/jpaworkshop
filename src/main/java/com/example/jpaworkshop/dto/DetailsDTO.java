package com.example.jpaworkshop.dto;

import com.example.jpaworkshop.entity.Details;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailsDTO {
    @Setter(AccessLevel.NONE)
    private int id;
    private String email;
    private String name;
    private LocalDate birthDate;

    public DetailsDTO(Details details) {
        this.id = details.getId();
        setName(details.getName());
        setEmail(details.getEmail());
        setBirthDate(details.getBirthDate());
    }
}
