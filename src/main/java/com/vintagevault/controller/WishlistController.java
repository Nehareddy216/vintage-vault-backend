package com.vintagevault.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.vintagevault.dto.WishlistRequest;
import com.vintagevault.dto.WishlistResponse;
import com.vintagevault.service.WishlistService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(
            WishlistService wishlistService) {

        this.wishlistService = wishlistService;
    }

    // Add product to wishlist
    @PostMapping("/add")
    public ResponseEntity<WishlistResponse> addToWishlist(
            @Valid @RequestBody WishlistRequest request,
            Authentication authentication) {

        return ResponseEntity.ok(
                wishlistService.addToWishlist(
                        request,
                        authentication.getName()
                )
        );
    }

    // Get buyer wishlist
    @GetMapping
    public ResponseEntity<List<WishlistResponse>> getWishlist(
            Authentication authentication) {

        return ResponseEntity.ok(
                wishlistService.getWishlist(
                        authentication.getName()
                )
        );
    }

    // Remove product from wishlist
    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<String> removeFromWishlist(
            @PathVariable Long productId,
            Authentication authentication) {

        return ResponseEntity.ok(
                wishlistService.removeFromWishlist(
                        productId,
                        authentication.getName()
                )
        );
    }

}