package com.E_Commerce.E_Commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.E_Commerce.E_Commerce.dtos.AddToCartRequest;
import com.E_Commerce.E_Commerce.dtos.RemoveCartItemDTO;
import com.E_Commerce.E_Commerce.dtos.UserIdDTO;
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

    @PostMapping("/add-modify")
    public Cart addToCart(@RequestBody AddToCartRequest req) {
        return cartServices.addToCart(req);
    }

    @DeleteMapping("/remove_cart")
    public String deleteCart(@RequestBody UserIdDTO userIdDTO) {
        return cartServices.deleteCart(userIdDTO);
    }

    @DeleteMapping("/remove_cart_item")
    public Cart deleteCartItem(@RequestBody RemoveCartItemDTO removeCartItemDTO) {
        return cartServices.deleteCartItem(removeCartItemDTO);
    }

    @GetMapping("/getAll")
    public Cart getCart(@RequestBody UserIdDTO userIdDTO) {
        return cartServices.getCart(userIdDTO);
    }

}
