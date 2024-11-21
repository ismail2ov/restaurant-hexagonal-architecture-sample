package com.github.ismail2ov.restaurant.application;

import com.github.ismail2ov.restaurant.domain.PaymentDetails;
import com.github.ismail2ov.restaurant.domain.PaymentService;

public class PaymentUseCase {

    public void processPayment(PaymentService paymentService, Long orderId, PaymentDetails paymentDetails) {
        paymentService.processPayment(orderId, paymentDetails);
    }
}
