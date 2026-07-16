package com.vintagevault.serviceimpl;

import org.springframework.stereotype.Service;

import com.vintagevault.dto.PaymentRequest;
import com.vintagevault.dto.PaymentResponse;
import com.vintagevault.entity.Order;
import com.vintagevault.entity.Payment;
import com.vintagevault.entity.User;
import com.vintagevault.repository.OrderRepository;
import com.vintagevault.repository.PaymentRepository;
import com.vintagevault.repository.UserRepository;
import com.vintagevault.service.PaymentService;


@Service
public class PaymentServiceImpl implements PaymentService {


    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;


    public PaymentServiceImpl(
            PaymentRepository paymentRepository,
            OrderRepository orderRepository,
            UserRepository userRepository) {

        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }



    // CREATE PAYMENT
    @Override
    public PaymentResponse createPayment(
            PaymentRequest request,
            String buyerEmail) {


        User buyer = userRepository
                .findByEmail(buyerEmail)
                .orElseThrow(() ->
                    new RuntimeException("User not found"));



        Order order = orderRepository
                .findById(request.getOrderId())
                .orElseThrow(() ->
                    new RuntimeException("Order not found"));



        // Check order belongs to buyer
        if(!order.getUser()
                .getEmail()
                .equals(buyerEmail)) {

            throw new RuntimeException(
                    "Access denied");
        }



        Payment payment = new Payment();

        payment.setOrder(order);

        payment.setAmount(
                order.getTotalAmount()
        );

        payment.setPaymentMethod(
                request.getPaymentMethod()
        );

        payment.setPaymentStatus(
                "PENDING"
        );


        Payment savedPayment =
                paymentRepository.save(payment);



        return mapToResponse(savedPayment);

    }



    // GET PAYMENT BY ORDER
    @Override
    public PaymentResponse getPaymentByOrder(
            Long orderId,
            String buyerEmail) {


        Order order =
                orderRepository.findById(orderId)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Order not found"));



        if(!order.getUser()
                .getEmail()
                .equals(buyerEmail)) {

            throw new RuntimeException(
                    "Access denied");
        }



        Payment payment =
                paymentRepository.findByOrderId(orderId);


        if(payment == null) {

            throw new RuntimeException(
                    "Payment not found");
        }


        return mapToResponse(payment);

    }



    // UPDATE PAYMENT STATUS
    @Override
    public PaymentResponse updatePaymentStatus(
            Long paymentId,
            String status) {


        Payment payment =
                paymentRepository.findById(paymentId)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Payment not found"));



        payment.setPaymentStatus(status);



        Payment saved =
                paymentRepository.save(payment);



        return mapToResponse(saved);

    }




    private PaymentResponse mapToResponse(
            Payment payment) {


        PaymentResponse response =
                new PaymentResponse();


        response.setPaymentId(
                payment.getId()
        );


        response.setOrderId(
                payment.getOrder().getId()
        );
        


        response.setAmount(
                payment.getAmount()
        );


        response.setPaymentMethod(
                payment.getPaymentMethod()
        );


        response.setPaymentStatus(
                payment.getPaymentStatus()
        );


        response.setPaymentDate(
                payment.getPaymentDate()
        );


        return response;

    }

}