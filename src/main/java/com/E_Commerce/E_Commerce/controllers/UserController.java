package com.E_Commerce.E_Commerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.E_Commerce.E_Commerce.models.User;
import com.E_Commerce.E_Commerce.services.UserServices;

@RestController
public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping()
    public String greet() {
        return userServices.greet();
    }

    @GetMapping("/users")
    public List<User> users() {
        return userServices.getusers();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userServices.addUser(user);
    }

    @PostMapping("/userLogin")
    public User userLogin(@RequestBody User user) {
        return userServices.loginUser(user);
    }

    @DeleteMapping("/deleteUsers")
    public void deleteAllUsers() {
        userServices.deleteAllUsers();
    }
}
