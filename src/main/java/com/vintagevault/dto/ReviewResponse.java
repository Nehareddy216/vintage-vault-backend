package com.vintagevault.dto;

import java.time.LocalDateTime;

public class ReviewResponse {

    private Long reviewId;

    private Long productId;

    private String productName;

    private String buyerName;

    private Integer rating;

    private String comment;

    private LocalDateTime createdAt;


    public Long getReviewId() {
        return reviewId;
    }


    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }


    public Long getProductId() {
        return productId;
    }


    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public String getBuyerName() {
        return buyerName;
    }


    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
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

}