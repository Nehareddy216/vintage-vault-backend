package com.vintagevault.service;

import org.springframework.stereotype.Service;

import com.vintagevault.dto.SellerProfileRequest;
import com.vintagevault.dto.SellerProfileResponse;
import com.vintagevault.entity.SellerProfile;
import com.vintagevault.entity.User;
import com.vintagevault.enums.VerificationStatus;
import com.vintagevault.repository.SellerProfileRepository;
import com.vintagevault.repository.UserRepository;

@Service
public class SellerProfileService {

    private final SellerProfileRepository sellerProfileRepository;
    private final UserRepository userRepository;

    public SellerProfileService(
            SellerProfileRepository sellerProfileRepository,
            UserRepository userRepository) {

        this.sellerProfileRepository = sellerProfileRepository;
        this.userRepository = userRepository;
    }

    // ==========================
    // Create Seller Profile
    // ==========================
    public SellerProfileResponse createSellerProfile(
            SellerProfileRequest request,
            String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (sellerProfileRepository.findByUser(user).isPresent()) {
            throw new RuntimeException("Seller profile already exists.");
        }

        SellerProfile seller = new SellerProfile();

        seller.setShopName(request.getShopName());
        seller.setOwnerName(request.getOwnerName());
        seller.setShopPhone(request.getShopPhone());
        seller.setShopEmail(request.getShopEmail());
        seller.setShopAddress(request.getShopAddress());
        seller.setCity(request.getCity());
        seller.setState(request.getState());
        seller.setCountry(request.getCountry());
        seller.setPincode(request.getPincode());
        seller.setShopDescription(request.getShopDescription());

        seller.setVerificationStatus(VerificationStatus.PENDING);
        seller.setSellerRating(0.0);
        seller.setTotalSales(0);

        seller.setUser(user);

        SellerProfile savedSeller = sellerProfileRepository.save(seller);

        return new SellerProfileResponse(
                savedSeller.getId(),
                savedSeller.getShopName(),
                savedSeller.getOwnerName(),
                savedSeller.getShopPhone(),
                savedSeller.getShopEmail(),
                savedSeller.getShopAddress(),
                savedSeller.getCity(),
                savedSeller.getState(),
                savedSeller.getCountry(),
                savedSeller.getPincode(),
                savedSeller.getShopDescription(),
                savedSeller.getVerificationStatus(),
                savedSeller.getSellerRating(),
                savedSeller.getTotalSales()
        );
    }

    // ==========================
    // Approve Seller
    // ==========================
    public String approveSeller(Long sellerId) {

        SellerProfile seller = sellerProfileRepository.findById(sellerId)
                .orElseThrow(() ->
                        new RuntimeException("Seller not found"));

        seller.setVerificationStatus(VerificationStatus.VERIFIED);

        sellerProfileRepository.save(seller);

        return "Seller approved successfully.";
    }

    // ==========================
    // Reject Seller
    // ==========================
    public String rejectSeller(Long sellerId) {

        SellerProfile seller = sellerProfileRepository.findById(sellerId)
                .orElseThrow(() ->
                        new RuntimeException("Seller not found"));

        seller.setVerificationStatus(VerificationStatus.REJECTED);

        sellerProfileRepository.save(seller);

        return "Seller rejected successfully.";
    }

}