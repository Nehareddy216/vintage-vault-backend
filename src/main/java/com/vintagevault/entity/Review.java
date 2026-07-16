package com.vintagevault.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private Integer rating;


    @Column(length = 1000)
    private String comment;


    private LocalDateTime createdAt;



    // Buyer who added review
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", nullable = false)
    private User buyer;



    // Product being reviewed
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;



    public Review() {

    }



    public Review(Integer rating,
                  String comment,
                  User buyer,
                  Product product) {

        this.rating = rating;
        this.comment = comment;
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



    public Integer getRating() {
        return rating;
    }


    public void setRating(Integer rating) {
        this.rating = rating;
    }



    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }



    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

}