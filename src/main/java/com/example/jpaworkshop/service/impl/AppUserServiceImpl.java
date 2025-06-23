package com.example.jpaworkshop.service.impl;

import com.example.jpaworkshop.entity.AppUser;
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
    public List<AppUser> getAllUsers() {
        List<AppUser> result = new ArrayList<>();
        appUserRepository.findAll().forEach((appUser) -> result.add(appUser));
        return result;
    }


    @Override

    public AppUser registerAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public Optional<AppUser> findAppUserById(int id) {
        return appUserRepository.findById(id);
    }

    @Override
    public Optional<AppUser> findAppUserByUsername(String username) {
        return appUserRepository.findAppUsersByUsername(username);
    }

    @Override
    public void updateAppUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }
}
