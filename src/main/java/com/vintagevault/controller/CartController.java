package com.vintagevault.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vintagevault.dto.AddToCartRequest;
import com.vintagevault.dto.CartResponse;
import com.vintagevault.dto.UpdateCartRequest;
import com.vintagevault.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {


    private final CartService cartService;


    public CartController(CartService cartService) {
        this.cartService = cartService;
    }



    // Add product to cart
    @PostMapping("/add")
    public ResponseEntity<CartResponse> addToCart(
            @RequestBody AddToCartRequest request) {

        return ResponseEntity.ok(
                cartService.addToCart(request)
        );
    }



    // View cart
    @GetMapping
    public ResponseEntity<CartResponse> getCart() {

        return ResponseEntity.ok(
                cartService.getCart()
        );
    }



    // Update quantity
    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<CartResponse> updateCart(
            @PathVariable Long cartItemId,
            @RequestBody UpdateCartRequest request) {


        return ResponseEntity.ok(
                cartService.updateCart(cartItemId, request)
        );

    }



    // Remove item
    @DeleteMapping("/remove/{cartItemId}")
    public ResponseEntity<String> removeFromCart(
            @PathVariable Long cartItemId) {


        cartService.removeFromCart(cartItemId);


        return ResponseEntity.ok(
                "Item removed from cart"
        );

    }

}
