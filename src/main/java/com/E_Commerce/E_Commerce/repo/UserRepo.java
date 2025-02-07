package com.E_Commerce.E_Commerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.E_Commerce.E_Commerce.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
