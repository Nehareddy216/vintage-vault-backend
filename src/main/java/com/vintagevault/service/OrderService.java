package com.vintagevault.service;

import java.util.List;

import com.vintagevault.dto.OrderRequest;
import com.vintagevault.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest request, String buyerEmail);

    List<OrderResponse> getMyOrders(String buyerEmail);

    OrderResponse getOrderById(Long orderId, String buyerEmail);

    OrderResponse cancelOrder(Long orderId, String buyerEmail);

}