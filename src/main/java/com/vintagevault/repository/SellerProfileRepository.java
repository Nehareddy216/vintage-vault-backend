package com.vintagevault.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vintagevault.entity.SellerProfile;
import com.vintagevault.entity.User;

public interface SellerProfileRepository extends JpaRepository<SellerProfile, Long> {

    Optional<SellerProfile> findByUser(User user);

}