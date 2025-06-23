package com.example.jpaworkshop.service;

import com.example.jpaworkshop.dto.appuser.AppUserDTO;
import com.example.jpaworkshop.dto.appuser.AppUserRegisterDTO;
import com.example.jpaworkshop.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    List<AppUserDTO> getAllUsers();

    AppUserRegisterDTO registerAppUser(AppUserRegisterDTO appUserRegisterDTO);

    Optional<AppUserDTO> findAppUserById(int id);

    Optional<AppUserDTO> findAppUserByUsername(String username);

    void updateAppUser(AppUser appUser);


}
