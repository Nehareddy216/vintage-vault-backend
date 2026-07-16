package com.vintagevault.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.vintagevault.dto.OrderRequest;
import com.vintagevault.dto.OrderResponse;
import com.vintagevault.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // ==========================
    // Place Order
    // ==========================
    @PostMapping("/place")
    public OrderResponse placeOrder(
            @Valid @RequestBody OrderRequest request,
            Authentication authentication) {

        return orderService.placeOrder(
                request,
                authentication.getName()
        );
    }

    // ==========================
    // Get My Orders
    // ==========================
    @GetMapping
    public List<OrderResponse> getMyOrders(
            Authentication authentication) {

        return orderService.getMyOrders(
                authentication.getName()
        );
    }

    // ==========================
    // Get Order By ID
    // ==========================
    @GetMapping("/{id}")
    public OrderResponse getOrderById(
            @PathVariable Long id,
            Authentication authentication) {

        return orderService.getOrderById(
                id,
                authentication.getName()
        );
    }

    // ==========================
    // Cancel Order
    // ==========================
    @PutMapping("/cancel/{id}")
    public OrderResponse cancelOrder(
            @PathVariable Long id,
            Authentication authentication) {

        return orderService.cancelOrder(
                id,
                authentication.getName()
        );
    }

}