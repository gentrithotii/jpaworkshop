package com.example.jpaworkshop.controller;

import com.example.jpaworkshop.entity.AppUser;
import com.example.jpaworkshop.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class AppUserController {
    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("appusers")
    public ResponseEntity<List<AppUser>> getUsers() {
        List<AppUser> result = appUserService.getAllUsers();
        return ResponseEntity.status(HttpStatus.FOUND).body(result);
    }


    @PostMapping("appuser")
    public ResponseEntity<AppUser> registerUser(@RequestBody AppUser user) {
        appUserService.registerAppUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
