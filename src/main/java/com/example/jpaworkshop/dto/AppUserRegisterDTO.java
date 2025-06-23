package com.example.jpaworkshop.dto;

import com.example.jpaworkshop.entity.AppUser;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AppUserRegisterDTO {
    @Setter(AccessLevel.NONE)
    private int id;
    private String username;
    private String password;
    private LocalDate regDate;
    private DetailsDTO userDetails;

    public AppUserRegisterDTO(AppUser appUser) {
        setUsername(appUser.getUsername());
        setRegDate(appUser.getRegDate());
        setUserDetails(new DetailsDTO(appUser.getUserDetails()));
    }
}
