package com.example.jpaworkshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    private AppUserService appUserService;

    @Autowired
    public AppUserService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }
}
