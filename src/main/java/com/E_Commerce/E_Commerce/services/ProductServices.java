package com.E_Commerce.E_Commerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_Commerce.E_Commerce.models.Product;
import com.E_Commerce.E_Commerce.repo.ProductRepo;

@Service
public class ProductServices {
    @Autowired
    ProductRepo productRepo;

    public Product addProduct(Product product) {
        System.out.println(product.toString());
        productRepo.save(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProduct(int id) {
        Optional<Product> optional_product = productRepo.findById(id);
        return optional_product.orElse(new Product());
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    public Product updateProduct(int id, Product product) {
        product.setId(id);
        return productRepo.save(product);
    }
}
