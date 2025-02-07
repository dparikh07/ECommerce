package com.E_Commerce.E_Commerce.services;

// import java.sql.Timestamp;
// import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.E_Commerce.E_Commerce.models.User;
import com.E_Commerce.E_Commerce.repo.UserRepo;

@Service
public class UserServices {

    @Autowired
    UserRepo userRepo;

    public String greet() {
        // Date date = new Date();
        // User user = new User("parikhdhaval148@gmail.com", "123",
        // "Dhaval", "Parikh", "user", new Timestamp(date.getTime()), new
        // Timestamp(date.getTime()));
        // userRepo.save(user);
        return "Hello";
    }
}
