package com.vintagevault.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SellerProfileRequest {

    @NotBlank(message = "Shop name is required")
    @Size(min = 3, max = 100, message = "Shop name must be between 3 and 100 characters")
    private String shopName;

    @NotBlank(message = "Owner name is required")
    @Size(min = 3, max = 50, message = "Owner name must be between 3 and 50 characters")
    private String ownerName;

    @NotBlank(message = "Shop phone number is required")
    @Pattern(
        regexp = "^[6-9]\\d{9}$",
        message = "Enter a valid 10-digit phone number"
    )
    private String shopPhone;

    @NotBlank(message = "Shop email is required")
    @Email(message = "Enter a valid email address")
    private String shopEmail;

    @NotBlank(message = "Shop address is required")
    @Size(min = 10, max = 200, message = "Shop address must be between 10 and 200 characters")
    private String shopAddress;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Pincode is required")
    @Pattern(
        regexp = "^[1-9][0-9]{5}$",
        message = "Enter a valid 6-digit pincode"
    )
    private String pincode;

    @NotBlank(message = "Shop description is required")
    @Size(min = 20, max = 500, message = "Description must be between 20 and 500 characters")
    private String shopDescription;

    public SellerProfileRequest() {
    }

    public SellerProfileRequest(String shopName,
                                String ownerName,
                                String shopPhone,
                                String shopEmail,
                                String shopAddress,
                                String city,
                                String state,
                                String country,
                                String pincode,
                                String shopDescription) {

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
}