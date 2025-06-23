package com.example.jpaworkshop.service;

import com.example.jpaworkshop.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    List<AppUser> getAllUsers();

    AppUser registerAppUser(AppUser appUser);

    Optional<AppUser> findAppUserById(int id);

    Optional<AppUser> findAppUserByUsername(String username);

    void updateAppUser(AppUser appUser);


}
