package com.example.jpaworkshop.controller;

import com.example.jpaworkshop.dto.appuser.AppUserDTO;
import com.example.jpaworkshop.dto.appuser.AppUserRegisterDTO;
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
    public ResponseEntity<List<AppUserDTO>> getUsers() {
        List<AppUserDTO> result = appUserService.getAllUsers();
        return ResponseEntity.status(HttpStatus.FOUND).body(result);
    }

    @PostMapping("appuser")
    public ResponseEntity<AppUserRegisterDTO> registerUser(@RequestBody AppUserRegisterDTO appUserRegisterDTO) {
        AppUserRegisterDTO user = appUserService.registerAppUser(appUserRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
