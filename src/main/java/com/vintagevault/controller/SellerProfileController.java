package com.vintagevault.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.vintagevault.dto.SellerProfileRequest;
import com.vintagevault.dto.SellerProfileResponse;
import com.vintagevault.service.SellerProfileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/seller")
public class SellerProfileController {

    private final SellerProfileService sellerProfileService;

    public SellerProfileController(SellerProfileService sellerProfileService) {
        this.sellerProfileService = sellerProfileService;
    }

    @PostMapping("/profile")
    public SellerProfileResponse createSellerProfile(
            @Valid @RequestBody SellerProfileRequest request,
            Authentication authentication) {

        return sellerProfileService.createSellerProfile(
                request,
                authentication.getName()
        );
    }

    @PutMapping("/approve/{sellerId}")
    public String approveSeller(
            @PathVariable Long sellerId) {

        return sellerProfileService.approveSeller(sellerId);
    }

    @PutMapping("/reject/{sellerId}")
    public String rejectSeller(
            @PathVariable Long sellerId) {

        return sellerProfileService.rejectSeller(sellerId);
    }

}