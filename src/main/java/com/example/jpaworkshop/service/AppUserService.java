package com.example.jpaworkshop.service;

import com.example.jpaworkshop.entity.AppUser;

import java.util.Optional;

public interface AppUserService {
    AppUser registerAppUser(AppUser appUser);

    Optional<AppUser> findAppUserById(int id);

    Optional<AppUser> findAppUserByUsername(String username);

    boolean updateAppUser(AppUser appUser);


}
