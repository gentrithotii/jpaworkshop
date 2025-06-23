package com.example.jpaworkshop.service.impl;

import com.example.jpaworkshop.dto.appuser.AppUserDTO;
import com.example.jpaworkshop.dto.appuser.AppUserRegisterDTO;
import com.example.jpaworkshop.entity.AppUser;
import com.example.jpaworkshop.entity.Details;
import com.example.jpaworkshop.repository.AppUserRepository;
import com.example.jpaworkshop.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public List<AppUserDTO> getAllUsers() {
        List<AppUserDTO> result = new ArrayList<>();
        appUserRepository.findAll().forEach((appUser) -> {
            result.add(new AppUserDTO(appUser));
        });

        return result;
    }


    @Override
    public AppUserRegisterDTO registerAppUser(AppUserRegisterDTO appUserRegisterDTO) {

        AppUser user = new AppUser(appUserRegisterDTO.getUsername(), appUserRegisterDTO.getPassword(), new Details(appUserRegisterDTO.getUserDetails().getEmail(), appUserRegisterDTO.getUserDetails().getName(), appUserRegisterDTO.getUserDetails().getBirthDate()));
        return new AppUserRegisterDTO(user);
    }

    @Override
    public Optional<AppUserDTO> findAppUserById(int id) {
        return appUserRepository.findById(id).map((user) -> new AppUserDTO(user));
    }

    @Override
    public Optional<AppUserDTO> findAppUserByUsername(String username) {
        return appUserRepository.findAppUsersByUsername(username).map((user) -> new AppUserDTO(user));
    }

    @Override
    public void updateAppUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }
}
