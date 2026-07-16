package com.vintagevault.dto;

public class ProductResponse {

    private Long id;
    private String productName;
    private String description;
    private Double price;
    private Integer quantity;
    private String imageUrl;
    private String sellerName;

    public ProductResponse() {
    }

    public ProductResponse(Long id,
                           String productName,
                           String description,
                           Double price,
                           Integer quantity,
                           String imageUrl,
                           String sellerName) {

        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.sellerName = sellerName;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}