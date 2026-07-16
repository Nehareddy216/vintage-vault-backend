package com.vintagevault.service;

import java.util.List;

import com.vintagevault.dto.ReviewRequest;
import com.vintagevault.dto.ReviewResponse;

public interface ReviewService {


    ReviewResponse addReview(
            ReviewRequest request,
            String buyerEmail
    );


    List<ReviewResponse> getProductReviews(
            Long productId
    );


    String deleteReview(
            Long reviewId,
            String buyerEmail
    );

}