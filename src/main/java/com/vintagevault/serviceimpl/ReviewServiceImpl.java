package com.vintagevault.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vintagevault.dto.ReviewRequest;
import com.vintagevault.dto.ReviewResponse;
import com.vintagevault.entity.Product;
import com.vintagevault.entity.Review;
import com.vintagevault.entity.User;
import com.vintagevault.repository.ProductRepository;
import com.vintagevault.repository.ReviewRepository;
import com.vintagevault.repository.UserRepository;
import com.vintagevault.service.ReviewService;


@Service
public class ReviewServiceImpl implements ReviewService {


    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;


    public ReviewServiceImpl(
            ReviewRepository reviewRepository,
            ProductRepository productRepository,
            UserRepository userRepository) {

        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }



    // ADD REVIEW
    @Override
    public ReviewResponse addReview(
            ReviewRequest request,
            String buyerEmail) {


        User buyer = userRepository
                .findByEmail(buyerEmail)
                .orElseThrow(() ->
                        new RuntimeException("Buyer not found"));



        Product product = productRepository
                .findById(request.getProductId())
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));



        if(request.getRating() == null ||
                request.getRating() < 1 ||
                request.getRating() > 5) {

            throw new RuntimeException(
                    "Rating must be between 1 and 5");
        }



        Review review = new Review();

        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setBuyer(buyer);
        review.setProduct(product);
        review.setCreatedAt(LocalDateTime.now());



        Review savedReview =
                reviewRepository.save(review);



        return mapToResponse(savedReview);

    }




    // GET REVIEWS OF A PRODUCT
    @Override
    public List<ReviewResponse> getProductReviews(
            Long productId) {


        List<Review> reviews =
                reviewRepository.findByProductId(productId);



        return reviews.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

    }




    // DELETE REVIEW
    @Override
    public String deleteReview(
            Long reviewId,
            String buyerEmail) {


        Review review =
                reviewRepository.findById(reviewId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Review not found"));



        if(!review.getBuyer()
                .getEmail()
                .equals(buyerEmail)) {


            throw new RuntimeException(
                    "You can delete only your own review");

        }



        reviewRepository.delete(review);


        return "Review deleted successfully";

    }




    // ENTITY TO RESPONSE DTO
    private ReviewResponse mapToResponse(
            Review review) {


        ReviewResponse response =
                new ReviewResponse();


        response.setReviewId(
                review.getId()
        );


        response.setRating(
                review.getRating()
        );


        response.setComment(
                review.getComment()
        );


        response.setBuyerName(
                review.getBuyer()
                .getEmail()
        );


        response.setProductId(
                review.getProduct()
                .getId()
        );
        response.setProductName(
                review.getProduct().getProductName()
        );


        response.setCreatedAt(
                review.getCreatedAt()
        );


        return response;

    }

}