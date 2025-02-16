package com.E_Commerce.E_Commerce.services;

import java.util.List;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_Commerce.E_Commerce.models.User;
import com.E_Commerce.E_Commerce.repo.UserRepo;

@Service
public class UserServices {

    @Autowired
    UserRepo userRepo;

    public String greet() {
        return "Hello";
    }

    public List<User> getusers() {
        return userRepo.findAll();
    }

    public User addUser(User user) {
        Date date = new Date();
        user.setCreated_at(new Timestamp(date.getTime()));
        return userRepo.save(user);
    }

    public User loginUser(User user) {
        User user1 = userRepo.findByEmail(user.getEmail());
        if (user1 == null) {
            System.out.println("Returning null");
            return null;
        }
        System.out.println(user1.toString());
        if (user.getPassword().equals(user1.getPassword())) {
            return user1;
        } else {
            return null;
        }
    }

    public void deleteAllUsers() {
        userRepo.deleteAll();
    }
}
