package com.vintagevault.controller;


import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.vintagevault.dto.ReviewRequest;
import com.vintagevault.dto.ReviewResponse;
import com.vintagevault.service.ReviewService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/reviews")
public class ReviewController {


    private final ReviewService reviewService;


    public ReviewController(
            ReviewService reviewService) {

        this.reviewService = reviewService;
    }



    // Add Review
    @PostMapping
    public ReviewResponse addReview(
            @Valid @RequestBody ReviewRequest request,
            Authentication authentication) {


        return reviewService.addReview(
                request,
                authentication.getName()
        );

    }



    // Get Product Reviews
    @GetMapping("/product/{productId}")
    public List<ReviewResponse> getProductReviews(
            @PathVariable Long productId) {


        return reviewService.getProductReviews(
                productId
        );

    }



    // Delete Review
    @DeleteMapping("/{reviewId}")
    public String deleteReview(
            @PathVariable Long reviewId,
            Authentication authentication) {


        return reviewService.deleteReview(
                reviewId,
                authentication.getName()
        );

    }

}