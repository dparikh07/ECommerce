package com.E_Commerce.E_Commerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.E_Commerce.E_Commerce.models.Product;
import com.E_Commerce.E_Commerce.services.ProductServices;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductServices productServices;

    // @PreAuthorize("hasRole('USER')")
    @PostMapping("admin/add")
    public Product addProduct(@RequestBody Product product) {
        return productServices.addProduct(product);
    }

    @GetMapping("/get")
    public List<Product> getProducts() {
        return productServices.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable int id) {
        return productServices.getProduct(id);
    }

    @DeleteMapping("admin/delete/{id}")
    public void deleteProduct(@PathVariable int id) {
        productServices.deleteProduct(id);
    }

    @PutMapping("admin/update/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productServices.updateProduct(id, product);
    }
}
