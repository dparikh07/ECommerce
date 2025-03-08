package com.E_Commerce.E_Commerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.E_Commerce.E_Commerce.models.User;
import com.E_Commerce.E_Commerce.services.UserServices;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping()
    public String greet() {
        return userServices.greet();
    }

    @GetMapping("admin/list")
    public List<User> users() {
        return userServices.getusers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userServices.getUser(id);
    }

    @PostMapping("/register")
    public User addUser(@RequestBody User user) {
        return userServices.addUser(user);
    }

    @GetMapping("/profile")
    public User userLogin(@RequestBody String email) {
        return userServices.profile(email);
    }

    @DeleteMapping("admin/delete/{id}")
    public void deleteAllUsers(@PathVariable int id) {
        userServices.deleteUser(id);
    }
}
