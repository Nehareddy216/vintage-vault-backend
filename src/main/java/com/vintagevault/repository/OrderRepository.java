package com.vintagevault.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vintagevault.entity.Order;
import com.vintagevault.entity.User;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);

}