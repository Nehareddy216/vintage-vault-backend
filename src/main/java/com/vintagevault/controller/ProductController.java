package com.vintagevault.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.vintagevault.dto.ProductRequest;
import com.vintagevault.dto.ProductResponse;
import com.vintagevault.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // ==========================
    // Add Product
    // ==========================
    @PostMapping
    public ProductResponse addProduct(
            @Valid @RequestBody ProductRequest request,
            Authentication authentication) {

        return productService.addProduct(
                request,
                authentication.getName()
        );
    }

    // ==========================
    // Get All Products
    // ==========================
    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    // ==========================
    // Get Product By Id
    // ==========================
    @GetMapping("/{id}")
    public ProductResponse getProductById(
            @PathVariable Long id) {

        return productService.getProductById(id);
    }

    // ==========================
    // Update Product
    // ==========================
    @PutMapping("/{id}")
    public ProductResponse updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {

        return productService.updateProduct(id, request);
    }

    // ==========================
    // Delete Product
    // ==========================
    @DeleteMapping("/{id}")
    public String deleteProduct(
            @PathVariable Long id) {

        return productService.deleteProduct(id);
    }

}