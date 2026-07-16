package com.vintagevault.serviceimpl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vintagevault.dto.WishlistRequest;
import com.vintagevault.dto.WishlistResponse;
import com.vintagevault.entity.Product;
import com.vintagevault.entity.User;
import com.vintagevault.entity.Wishlist;
import com.vintagevault.repository.ProductRepository;
import com.vintagevault.repository.UserRepository;
import com.vintagevault.repository.WishlistRepository;
import com.vintagevault.service.WishlistService;


@Service
public class WishlistServiceImpl implements WishlistService {


    private final WishlistRepository wishlistRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;



    public WishlistServiceImpl(
            WishlistRepository wishlistRepository,
            ProductRepository productRepository,
            UserRepository userRepository) {

        this.wishlistRepository = wishlistRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;

    }



    @Override
    public WishlistResponse addToWishlist(
            WishlistRequest request,
            String buyerEmail) {


        User buyer = userRepository
                .findByEmail(buyerEmail)
                .orElseThrow(() ->
                        new RuntimeException("Buyer not found"));



        Product product = productRepository
                .findById(request.getProductId())
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));



        if(wishlistRepository
                .findByBuyerAndProduct(buyer, product)
                .isPresent()) {

            throw new RuntimeException(
                    "Product already in wishlist");

        }



        Wishlist wishlist = new Wishlist();

        wishlist.setBuyer(buyer);
        wishlist.setProduct(product);



        Wishlist saved =
                wishlistRepository.save(wishlist);



        return mapToResponse(saved);

    }





    @Override
    public List<WishlistResponse> getWishlist(
            String buyerEmail) {


        User buyer = userRepository
                .findByEmail(buyerEmail)
                .orElseThrow(() ->
                        new RuntimeException("Buyer not found"));



        return wishlistRepository
                .findByBuyer(buyer)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

    }





    @Override
    @Transactional
    public String removeFromWishlist(
            Long productId,
            String buyerEmail) {


        User buyer = userRepository
                .findByEmail(buyerEmail)
                .orElseThrow(() ->
                        new RuntimeException("Buyer not found"));



        Product product = productRepository
                .findById(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));



        wishlistRepository
                .deleteByBuyerAndProduct(
                        buyer,
                        product
                );


        return "Removed from wishlist";

    }





    private WishlistResponse mapToResponse(
            Wishlist wishlist) {


        Product product = wishlist.getProduct();



        return new WishlistResponse(

                wishlist.getId(),

                product.getId(),

                product.getProductName(),

                product.getPrice(),

                product.getImageUrl(),

                wishlist.getCreatedAt()

        );

    }

}