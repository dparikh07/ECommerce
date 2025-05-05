package com.E_Commerce.E_Commerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.E_Commerce.E_Commerce.models.Cart_Items;

@Repository
public interface Cart_Items_Repo extends JpaRepository<Cart_Items, Integer> {

}
