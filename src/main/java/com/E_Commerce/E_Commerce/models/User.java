package com.E_Commerce.E_Commerce.models;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private int id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String role;
    private Timestamp created_at;
    private Timestamp updated_at;

    public String getUsername() {
        return email;
    }
}
