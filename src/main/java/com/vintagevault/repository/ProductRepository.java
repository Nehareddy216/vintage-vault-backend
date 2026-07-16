package com.vintagevault.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vintagevault.entity.Product;
import com.vintagevault.entity.SellerProfile;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findBySeller(SellerProfile seller);

}