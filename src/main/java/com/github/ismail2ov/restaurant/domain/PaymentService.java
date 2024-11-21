package com.github.ismail2ov.restaurant.domain;

public interface PaymentService {

    void processPayment(Long orderId, PaymentDetails paymentDetails);
}
