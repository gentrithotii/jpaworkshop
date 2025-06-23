package com.example.jpaworkshop.dto.appuser;

import com.example.jpaworkshop.entity.AppUser;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDTO {

    @Setter(AccessLevel.NONE)
    private int id;
    private String username;
    private String password;
    private LocalDate regDate;
    private DetailsDTO userDetails;

    public AppUserDTO(AppUser appUser) {
        this.id = appUser.getId();
        setUsername(appUser.getUsername());
        setPassword(appUser.getPassword());
        setRegDate(appUser.getRegDate());
        setUserDetails(new DetailsDTO(appUser.getUserDetails()));
    }

}