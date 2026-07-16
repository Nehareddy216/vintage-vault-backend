package com.vintagevault.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vintagevault.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}