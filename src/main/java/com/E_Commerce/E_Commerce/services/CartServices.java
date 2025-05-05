package com.E_Commerce.E_Commerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_Commerce.E_Commerce.dtos.AddToCartRequest;
import com.E_Commerce.E_Commerce.models.Cart;
import com.E_Commerce.E_Commerce.models.Cart_Items;
import com.E_Commerce.E_Commerce.repo.CartRepo;
import com.E_Commerce.E_Commerce.repo.Cart_Items_Repo;
import com.E_Commerce.E_Commerce.repo.ProductRepo;
import com.E_Commerce.E_Commerce.repo.UserRepo;

@Service
public class CartServices {
    @Autowired
    Cart_Items_Repo cart_ItemsRepo;

    @Autowired
    CartRepo cartRepo;

    @Autowired
    ProductRepo productRepo;
    @Autowired
    UserRepo userRepo;

    public Cart addToCart(AddToCartRequest req) {
        System.out.println("Here");
        Optional<Cart> cart = cartRepo.findByUserId(req.getUserId());
        if (cart.isPresent()) {
            Cart newCart = cart.get();
            List<Cart_Items> cart_Items = newCart.getCart_Items();
            boolean workDone = false;
            for (int i = 0; i < cart_Items.size(); i++) {
                if (cart_Items.get(i).getProduct().getId() == req.getProductId()) {
                    workDone = true;
                    cart_Items.get(i).setQuantity(req.getQuantity());
                    cart_ItemsRepo.save(cart_Items.get(i));
                }
            }
            if (!workDone) {
                Cart_Items cart_Items2 = new Cart_Items();
                cart_Items2.setCart(newCart);
                cart_Items2.setProduct(productRepo.findById(req.getProductId()).get());
                cart_Items2.setQuantity(req.getQuantity());
                newCart.getCart_Items().add(cart_Items2);
                cart_ItemsRepo.save(cart_Items2);
            }
            cartRepo.save(newCart);
            return newCart;
        } else {
            Cart newCart = new Cart();
            newCart.setUser(userRepo.findById(req.getUserId()).get());
            cartRepo.save(newCart);
            Cart_Items cart_Items2 = new Cart_Items();
            cart_Items2.setCart(newCart);
            cart_Items2.setProduct(productRepo.findById(req.getProductId()).get());
            cart_Items2.setQuantity(req.getQuantity());
            newCart.setCart_Items(List.of(cart_Items2));
            cart_ItemsRepo.save(cart_Items2);
            return newCart;
        }
    }
}
