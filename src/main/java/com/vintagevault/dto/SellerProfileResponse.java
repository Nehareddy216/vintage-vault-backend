package com.vintagevault.dto;

import com.vintagevault.enums.VerificationStatus;

public class SellerProfileResponse {

    private Long id;
    private String shopName;
    private String ownerName;
    private String shopPhone;
    private String shopEmail;
    private String shopAddress;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String shopDescription;
    private VerificationStatus verificationStatus;
    private Double sellerRating;
    private Integer totalSales;

    public SellerProfileResponse() {
    }

    public SellerProfileResponse(Long id,
                                 String shopName,
                                 String ownerName,
                                 String shopPhone,
                                 String shopEmail,
                                 String shopAddress,
                                 String city,
                                 String state,
                                 String country,
                                 String pincode,
                                 String shopDescription,
                                 VerificationStatus verificationStatus,
                                 Double sellerRating,
                                 Integer totalSales) {

        this.id = id;
        this.shopName = shopName;
        this.ownerName = ownerName;
        this.shopPhone = shopPhone;
        this.shopEmail = shopEmail;
        this.shopAddress = shopAddress;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.shopDescription = shopDescription;
        this.verificationStatus = verificationStatus;
        this.sellerRating = sellerRating;
        this.totalSales = totalSales;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public String getShopEmail() {
        return shopEmail;
    }

    public void setShopEmail(String shopEmail) {
        this.shopEmail = shopEmail;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public VerificationStatus getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(VerificationStatus verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public Double getSellerRating() {
        return sellerRating;
    }

    public void setSellerRating(Double sellerRating) {
        this.sellerRating = sellerRating;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }
}