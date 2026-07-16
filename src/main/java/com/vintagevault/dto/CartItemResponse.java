package com.vintagevault.dto;

public class CartItemResponse {

    private Long cartItemId;
    private Long productId;
    private String productName;
    private double price;
    private Integer quantity;
    private String imageUrl;


    public CartItemResponse() {
    }


    public CartItemResponse(
            Long cartItemId,
            Long productId,
            String productName,
            double price,
            Integer quantity,
            String imageUrl) {

        this.cartItemId = cartItemId;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }


    public Long getCartItemId() {
        return cartItemId;
    }


    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
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


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
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

}