package com.vintagevault.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vintagevault.entity.Product;
import com.vintagevault.entity.User;
import com.vintagevault.entity.Wishlist;


@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {


    // Get all wishlist products of a buyer
    List<Wishlist> findByBuyer(User buyer);



    // Check whether product already exists in wishlist
    Optional<Wishlist> findByBuyerAndProduct(
            User buyer,
            Product product
    );



    // Remove specific product from wishlist
    void deleteByBuyerAndProduct(
            User buyer,
            Product product
    );

}