package com.E_Commerce.E_Commerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.E_Commerce.E_Commerce.models.Product;
import com.E_Commerce.E_Commerce.services.ProductServices;

@RestController
public class ProductController {
    @Autowired
    ProductServices productServices;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productServices.addProduct(product);
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return productServices.getAllProducts();
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable int id) {
        return productServices.getProduct(id);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable int id) {
        productServices.deleteProduct(id);
    }

    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productServices.updateProduct(id, product);
    }
}
