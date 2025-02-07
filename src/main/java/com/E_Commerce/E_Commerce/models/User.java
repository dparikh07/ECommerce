package com.E_Commerce.E_Commerce.models;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
public class User {
    @Id
    public int id;
    public String email;
    public String password;
    public String first_name;
    public String last_name;
    public String role;
    public Timestamp created_at;
    public Timestamp updated_at;

    public User() {
    }

    public User(String email, String password, String first_name, String last_name, String role,
            Timestamp created_at, Timestamp updated_at) {
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
