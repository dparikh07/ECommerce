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
public class Product {
    @Id
    private int id;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private String imageURL;
    // private Timestamp createdAt;
    // private Timestamp updatedAt;
}
