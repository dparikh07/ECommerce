package com.E_Commerce.E_Commerce.services;

import java.util.List;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.E_Commerce.E_Commerce.models.User;
import com.E_Commerce.E_Commerce.repo.UserRepo;

@Service
public class UserServices {

    @Autowired
    UserRepo userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public String greet() {
        return "Hello";
    }

    public List<User> getusers() {
        return userRepo.findAll();
    }

    public User addUser(User user) {
        Date date = new Date();
        user.setCreated_at(new Timestamp(date.getTime()));
        String new_Password = encoder.encode(user.getPassword());
        System.out.println(new_Password);
        user.setPassword(new_Password);
        return userRepo.save(user);
    }

    public User profile(String email) {
        return userRepo.findByEmail(email);
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    public User getUser(int id) {
        return userRepo.findById(id).orElse(null);
    }
}
