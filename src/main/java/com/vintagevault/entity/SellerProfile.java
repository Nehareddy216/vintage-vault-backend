package com.vintagevault.entity;

import java.time.LocalDateTime;

import com.vintagevault.enums.VerificationStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "seller_profiles")
public class SellerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String shopName;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private String shopPhone;

    @Column(nullable = false)
    private String shopEmail;

    @Column(nullable = false)
    private String shopAddress;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String pincode;

    @Column(length = 1000)
    private String shopDescription;

    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus = VerificationStatus.PENDING;

    private Double sellerRating = 0.0;

    private Integer totalSales = 0;

    private LocalDateTime joinedDate = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    // Default Constructor
    public SellerProfile() {
    }

    // Parameterized Constructor
    public SellerProfile(Long id, String shopName, String ownerName,
                         String shopPhone, String shopEmail,
                         String shopAddress, String city,
                         String state, String country,
                         String pincode, String shopDescription,
                         VerificationStatus verificationStatus,
                         Double sellerRating, Integer totalSales,
                         LocalDateTime joinedDate, User user) {

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
        this.joinedDate = joinedDate;
        this.user = user;
    }

    // Getters and Setters

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

    public LocalDateTime getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDateTime joinedDate) {
        this.joinedDate = joinedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}