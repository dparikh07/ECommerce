package com.E_Commerce.E_Commerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.E_Commerce.E_Commerce.models.User;
import com.E_Commerce.E_Commerce.models.UserPrincipal;
import com.E_Commerce.E_Commerce.repo.UserRepo;

@Component
public class CustomUserDetailsServices implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepo.findByEmail(email);

        // TODO Auto-generated method stub
        return new UserPrincipal(user);
    }
}
