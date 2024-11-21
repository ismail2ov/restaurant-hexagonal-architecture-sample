package com.github.ismail2ov.restaurant.domain;

public interface PaymentService {

    boolean processPayment(Long orderId, PaymentDetails paymentDetails);
}
