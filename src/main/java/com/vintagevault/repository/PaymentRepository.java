package com.vintagevault.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vintagevault.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findByOrderId(Long orderId);

}