package com.vintagevault.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "wishlists")
public class Wishlist {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    // Buyer who added wishlist item
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", nullable = false)
    private User buyer;



    // Product added to wishlist
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;



    private LocalDateTime createdAt;



    public Wishlist() {

    }



    public Wishlist(User buyer, Product product) {

        this.buyer = buyer;
        this.product = product;
        this.createdAt = LocalDateTime.now();

    }



    @PrePersist
    public void prePersist() {

        if(createdAt == null) {
            createdAt = LocalDateTime.now();
        }

    }



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }



    public User getBuyer() {
        return buyer;
    }


    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }



    public Product getProduct() {
        return product;
    }


    public void setProduct(Product product) {
        this.product = product;
    }



    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}