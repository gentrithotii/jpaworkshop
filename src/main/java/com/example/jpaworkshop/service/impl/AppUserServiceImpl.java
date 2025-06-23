package com.example.jpaworkshop.service.impl;

import com.example.jpaworkshop.entity.AppUser;
import com.example.jpaworkshop.repository.AppUserRepository;
import com.example.jpaworkshop.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {
    private AppUserRepository appUserRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }


    @Override
    public AppUser registerAppUser(AppUser appUser) {
        return null;
    }

    @Override
    public Optional<AppUser> findAppUserById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<AppUser> findAppUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public boolean updateAppUser(AppUser appUser) {
        return false;
    }
}
