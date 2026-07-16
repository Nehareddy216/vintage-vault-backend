package com.vintagevault.dto;

import java.time.LocalDateTime;

public class PaymentResponse {

    private Long paymentId;

    private Long orderId;

    private Double amount;

    private String paymentMethod;

    private String paymentStatus;

    private LocalDateTime paymentDate;


    public Long getPaymentId() {
        return paymentId;
    }


    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }


    public Long getOrderId() {
        return orderId;
    }


    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    public Double getAmount() {
        return amount;
    }


    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public String getPaymentMethod() {
        return paymentMethod;
    }


    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public String getPaymentStatus() {
        return paymentStatus;
    }


    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }


    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

}