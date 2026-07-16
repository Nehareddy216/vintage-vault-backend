package com.vintagevault.service;

import java.util.List;

import com.vintagevault.dto.WishlistRequest;
import com.vintagevault.dto.WishlistResponse;


public interface WishlistService {


    WishlistResponse addToWishlist(
            WishlistRequest request,
            String buyerEmail
    );


    List<WishlistResponse> getWishlist(
            String buyerEmail
    );


    String removeFromWishlist(
            Long productId,
            String buyerEmail
    );

}