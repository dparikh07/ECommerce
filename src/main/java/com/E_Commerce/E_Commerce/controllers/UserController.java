package com.E_Commerce.E_Commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.E_Commerce.E_Commerce.services.UserServices;

@RestController
public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping()
    public String greet() {
        return userServices.greet();
    }
}
