package com.vintagevault.dto;

import jakarta.validation.constraints.NotNull;

public class WishlistRequest {

    @NotNull(message = "Product ID is required")
    private Long productId;

    public WishlistRequest() {
    }

    public WishlistRequest(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}