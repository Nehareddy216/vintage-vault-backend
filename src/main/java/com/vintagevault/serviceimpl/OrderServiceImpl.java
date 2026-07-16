package com.vintagevault.serviceimpl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vintagevault.dto.OrderItemResponse;
import com.vintagevault.dto.OrderRequest;
import com.vintagevault.dto.OrderResponse;

import com.vintagevault.entity.Cart;
import com.vintagevault.entity.CartItem;
import com.vintagevault.entity.Order;
import com.vintagevault.entity.OrderItem;
import com.vintagevault.entity.Product;
import com.vintagevault.entity.User;

import com.vintagevault.repository.CartRepository;
import com.vintagevault.repository.OrderItemRepository;
import com.vintagevault.repository.OrderRepository;
import com.vintagevault.repository.UserRepository;

import com.vintagevault.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    private final CartRepository cartRepository;

    private final UserRepository userRepository;



    public OrderServiceImpl(

            OrderRepository orderRepository,

            OrderItemRepository orderItemRepository,

            CartRepository cartRepository,

            UserRepository userRepository

    ) {

        this.orderRepository = orderRepository;

        this.orderItemRepository = orderItemRepository;

        this.cartRepository = cartRepository;

        this.userRepository = userRepository;

    }




    // PLACE ORDER
    @Override
    public OrderResponse placeOrder(

            OrderRequest request,

            String buyerEmail

    ) {


        User buyer = userRepository
                .findByEmail(buyerEmail)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));



        Cart cart = cartRepository
                .findByUserId(buyer.getId())
                .orElseThrow(() ->
                        new RuntimeException("Cart not found"));



        if(cart.getItems().isEmpty()) {

            throw new RuntimeException(
                    "Cart is empty"
            );

        }



        Order order = new Order();


        order.setUser(buyer);

        order.setStatus("PLACED");



        order.setFullName(
                request.getFullName()
        );


        order.setPhoneNumber(
                request.getPhoneNumber()
        );


        order.setShippingAddress(
                request.getShippingAddress()
        );


        order.setCity(
                request.getCity()
        );


        order.setState(
                request.getState()
        );


        order.setPinCode(
                request.getPinCode()
        );



        double total = 0;



        for(CartItem cartItem : cart.getItems()) {


            Product product =
                    cartItem.getProduct();



            OrderItem orderItem =
                    new OrderItem();



            orderItem.setOrder(order);

            orderItem.setProduct(product);

            orderItem.setQuantity(
                    cartItem.getQuantity()
            );

            orderItem.setPrice(
                    product.getPrice()
            );



            order.getOrderItems()
                    .add(orderItem);



            total += product.getPrice()
                    *
                    cartItem.getQuantity();

        }



        order.setTotalAmount(total);



        Order savedOrder =
                orderRepository.save(order);



        orderItemRepository.saveAll(
                savedOrder.getOrderItems()
        );



        // Clear cart after successful order

        cart.getItems().clear();

        cartRepository.save(cart);



        return mapToResponse(savedOrder);

    }





    // GET MY ORDERS
    @Override
    public List<OrderResponse> getMyOrders(

            String buyerEmail

    ) {


        User buyer = userRepository

                .findByEmail(buyerEmail)

                .orElseThrow(() ->
                        new RuntimeException("User not found"));



        return orderRepository

                .findByUser(buyer)

                .stream()

                .map(this::mapToResponse)

                .collect(Collectors.toList());

    }





    // GET ORDER BY ID
    @Override
    public OrderResponse getOrderById(

            Long orderId,

            String buyerEmail

    ) {


        Order order =
                orderRepository.findById(orderId)

                .orElseThrow(() ->
                        new RuntimeException(
                                "Order not found"
                        ));



        if(!order.getUser()
                .getEmail()
                .equals(buyerEmail)) {


            throw new RuntimeException(
                    "Access denied"
            );

        }



        return mapToResponse(order);

    }





    // CANCEL ORDER
    @Override
    public OrderResponse cancelOrder(

            Long orderId,

            String buyerEmail

    ) {


        Order order =
                orderRepository.findById(orderId)

                .orElseThrow(() ->
                        new RuntimeException(
                                "Order not found"
                        ));



        if(!order.getUser()
                .getEmail()
                .equals(buyerEmail)) {


            throw new RuntimeException(
                    "Access denied"
            );

        }



        order.setStatus("CANCELLED");



        Order savedOrder =
                orderRepository.save(order);



        return mapToResponse(savedOrder);

    }





    private OrderResponse mapToResponse(

            Order order

    ) {



        OrderResponse response =
                new OrderResponse();



        response.setFullName(
                order.getFullName()
        );


        response.setPhoneNumber(
                order.getPhoneNumber()
        );


        response.setShippingAddress(
                order.getShippingAddress()
        );


        response.setCity(
                order.getCity()
        );


        response.setState(
                order.getState()
        );


        response.setPinCode(
                order.getPinCode()
        );



        List<OrderItemResponse> items =

                order.getOrderItems()

                .stream()

                .map(item ->

                        new OrderItemResponse(

                                item.getProduct().getId(),

                                item.getProduct().getProductName(),

                                item.getQuantity(),

                                item.getPrice()

                        )

                )

                .collect(Collectors.toList());



        response.setItems(items);



        return response;

    }

}