package com.vintagevault.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.vintagevault.service.CartService;
import com.vintagevault.dto.AddToCartRequest;
import com.vintagevault.dto.CartItemResponse;
import com.vintagevault.dto.CartResponse;
import com.vintagevault.dto.UpdateCartRequest;
import com.vintagevault.entity.Cart;
import com.vintagevault.entity.CartItem;
import com.vintagevault.entity.Product;
import com.vintagevault.entity.User;
import com.vintagevault.repository.CartItemRepository;
import com.vintagevault.repository.CartRepository;
import com.vintagevault.repository.ProductRepository;
import com.vintagevault.repository.UserRepository;


@Service
public class CartServiceImpl implements CartService {


    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;



    public CartServiceImpl(
            CartRepository cartRepository,
            CartItemRepository cartItemRepository,
            ProductRepository productRepository,
            UserRepository userRepository) {

        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;

    }




    @Override
    public CartResponse addToCart(AddToCartRequest request) {


        Authentication authentication =
                SecurityContextHolder.getContext()
                .getAuthentication();


        String email = authentication.getName();



        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));



        Cart cart = cartRepository.findByUserId(user.getId())
                .orElseGet(() -> {

                    Cart newCart = new Cart();

                    newCart.setUser(user);

                    return cartRepository.save(newCart);

                });



        Product product = productRepository.findById(
                request.getProductId()
        )
        .orElseThrow(() ->
                new RuntimeException("Product not found"));



        CartItem cartItem =
                cartItemRepository
                .findByCartAndProduct(cart, product)
                .orElse(null);



        if(cartItem != null){


            cartItem.setQuantity(
                    cartItem.getQuantity()
                    + request.getQuantity()
            );


        }
        else{


            cartItem = new CartItem();

            cartItem.setCart(cart);

            cartItem.setProduct(product);

            cartItem.setQuantity(
                    request.getQuantity()
            );

        }



        cartItemRepository.save(cartItem);



        return buildCartResponse(cart);

    }







    @Override
    public CartResponse getCart() {


        Authentication authentication =
                SecurityContextHolder.getContext()
                .getAuthentication();


        String email = authentication.getName();



        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));



        Cart cart = cartRepository.findByUserId(user.getId())
                .orElseThrow(() ->
                        new RuntimeException("Cart not found"));



        return buildCartResponse(cart);

    }







    @Override
    public CartResponse updateCart(
            Long cartItemId,
            UpdateCartRequest request) {



        CartItem item =
                cartItemRepository.findById(cartItemId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Cart item not found"
                        ));



        item.setQuantity(request.getQuantity());


        cartItemRepository.save(item);



        return buildCartResponse(
                item.getCart()
        );

    }







    @Override
    public void removeFromCart(Long cartItemId) {


        cartItemRepository.deleteById(cartItemId);


    }







    private CartResponse buildCartResponse(Cart cart){



        List<CartItem> cartItems =
                cartItemRepository.findByCart(cart);



        List<CartItemResponse> responseItems =
                new ArrayList<>();



        double total = 0;



        for(CartItem item : cartItems){



            Product product =
                    item.getProduct();



            responseItems.add(
            		new CartItemResponse(

            		        item.getId(),

            		        product.getId(),

            		        product.getProductName(),

            		        product.getPrice(),

            		        item.getQuantity(),

            		        product.getImageUrl()

            		)
                    

            );



            total += product.getPrice()
                    * item.getQuantity();



        }





        CartResponse response =
                new CartResponse();



        response.setCartId(
                cart.getId()
        );


        response.setItems(
                responseItems
        );


        response.setTotalAmount(
                total
        );



        return response;


    }



}