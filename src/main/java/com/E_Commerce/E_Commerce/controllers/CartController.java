package com.E_Commerce.E_Commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.E_Commerce.E_Commerce.dtos.AddToCartRequest;
import com.E_Commerce.E_Commerce.models.Cart;
import com.E_Commerce.E_Commerce.services.CartServices;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartServices cartServices;

    @GetMapping("/")
    public String greet() {
        return "Hello";
    }

    @PostMapping("/add")
    public Cart addToCart(@RequestBody AddToCartRequest req) {
        return cartServices.addToCart(req);
    }

    @GetMapping("/add")
    public String greet2() {
        return "Hello";
    }

}
