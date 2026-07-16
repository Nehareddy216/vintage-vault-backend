package com.vintagevault.service;

import com.vintagevault.dto.AddToCartRequest;
import com.vintagevault.dto.CartResponse;
import com.vintagevault.dto.UpdateCartRequest;

public interface CartService {

    CartResponse addToCart(AddToCartRequest request);

    CartResponse getCart();

    CartResponse updateCart(Long cartItemId, UpdateCartRequest request);

    void removeFromCart(Long cartItemId);

}