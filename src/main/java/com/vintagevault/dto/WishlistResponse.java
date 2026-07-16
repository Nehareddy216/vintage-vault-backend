package com.vintagevault.dto;

import java.time.LocalDateTime;


public class WishlistResponse {


    private Long id;

    private Long productId;

    private String productName;

    private Double price;

    private String imageUrl;

    private LocalDateTime addedDate;



    public WishlistResponse() {

    }



    public WishlistResponse(
            Long id,
            Long productId,
            String productName,
            Double price,
            String imageUrl,
            LocalDateTime addedDate) {

        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.addedDate = addedDate;

    }



    public Long getId() {
        return id;
    }


    public Long getProductId() {
        return productId;
    }


    public String getProductName() {
        return productName;
    }


    public Double getPrice() {
        return price;
    }


    public String getImageUrl() {
        return imageUrl;
    }


    public LocalDateTime getAddedDate() {
        return addedDate;
    }

}