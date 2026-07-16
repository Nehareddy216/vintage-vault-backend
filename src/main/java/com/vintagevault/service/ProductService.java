package com.vintagevault.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vintagevault.dto.ProductRequest;
import com.vintagevault.dto.ProductResponse;
import com.vintagevault.entity.Product;
import com.vintagevault.entity.SellerProfile;
import com.vintagevault.entity.User;
import com.vintagevault.enums.VerificationStatus;
import com.vintagevault.repository.ProductRepository;
import com.vintagevault.repository.SellerProfileRepository;
import com.vintagevault.repository.UserRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final SellerProfileRepository sellerProfileRepository;
    private final UserRepository userRepository;

    public ProductService(
            ProductRepository productRepository,
            SellerProfileRepository sellerProfileRepository,
            UserRepository userRepository) {

        this.productRepository = productRepository;
        this.sellerProfileRepository = sellerProfileRepository;
        this.userRepository = userRepository;
    }

    // ==========================
    // Add Product
    // ==========================
    public ProductResponse addProduct(
            ProductRequest request,
            String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        SellerProfile seller = sellerProfileRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Seller profile not found"));

        if (seller.getVerificationStatus() != VerificationStatus.VERIFIED) {
            throw new RuntimeException(
                    "Seller is not verified. Product cannot be added."
            );
        }

        Product product = new Product();

        product.setProductName(request.getProductName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setImageUrl(request.getImageUrl());
        product.setSeller(seller);

        Product savedProduct = productRepository.save(product);

        return new ProductResponse(
                savedProduct.getId(),
                savedProduct.getProductName(),
                savedProduct.getDescription(),
                savedProduct.getPrice(),
                savedProduct.getQuantity(),
                savedProduct.getImageUrl(),
                seller.getShopName()
        );
    }

    // ==========================
    // Get All Products
    // ==========================
    public List<ProductResponse> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getProductName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getQuantity(),
                        product.getImageUrl(),
                        product.getSeller().getShopName()
                ))
                .toList();
    }

    // ==========================
    // Get Product By Id
    // ==========================
    public ProductResponse getProductById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        return new ProductResponse(
                product.getId(),
                product.getProductName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                product.getImageUrl(),
                product.getSeller().getShopName()
        );
    }

    // ==========================
    // Update Product
    // ==========================
    public ProductResponse updateProduct(
            Long id,
            ProductRequest request) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        product.setProductName(request.getProductName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setImageUrl(request.getImageUrl());

        Product updatedProduct = productRepository.save(product);

        return new ProductResponse(
                updatedProduct.getId(),
                updatedProduct.getProductName(),
                updatedProduct.getDescription(),
                updatedProduct.getPrice(),
                updatedProduct.getQuantity(),
                updatedProduct.getImageUrl(),
                updatedProduct.getSeller().getShopName()
        );
    }

    // ==========================
    // Delete Product
    // ==========================
    public String deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        productRepository.delete(product);

        return "Product deleted successfully.";
    }

}