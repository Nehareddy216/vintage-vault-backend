package com.vintagevault.service;

import com.vintagevault.dto.PaymentRequest;
import com.vintagevault.dto.PaymentResponse;

public interface PaymentService {

    PaymentResponse createPayment(
            PaymentRequest request,
            String buyerEmail
    );


    PaymentResponse getPaymentByOrder(
            Long orderId,
            String buyerEmail
    );


    PaymentResponse updatePaymentStatus(
            Long paymentId,
            String status
    );

}