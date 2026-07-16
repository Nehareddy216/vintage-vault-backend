package com.vintagevault.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.vintagevault.dto.PaymentRequest;
import com.vintagevault.dto.PaymentResponse;
import com.vintagevault.service.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // ==========================
    // Create Payment
    // ==========================
    @PostMapping("/create")
    public PaymentResponse createPayment(
            @Valid @RequestBody PaymentRequest request,
            Authentication authentication) {

        return paymentService.createPayment(
                request,
                authentication.getName()
        );
    }

    // ==========================
    // Get Payment By Order
    // ==========================
    @GetMapping("/order/{orderId}")
    public PaymentResponse getPaymentByOrder(
            @PathVariable Long orderId,
            Authentication authentication) {

        return paymentService.getPaymentByOrder(
                orderId,
                authentication.getName()
        );
    }

    // ==========================
    // Update Payment Status
    // ==========================
    @PutMapping("/{paymentId}/status")
    public PaymentResponse updateStatus(
            @PathVariable Long paymentId,
            @RequestParam String status) {

        return paymentService.updatePaymentStatus(
                paymentId,
                status
        );
    }

}