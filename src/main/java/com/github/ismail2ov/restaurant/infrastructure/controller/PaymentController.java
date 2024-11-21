package com.github.ismail2ov.restaurant.infrastructure.controller;

import com.github.ismail2ov.restaurant.domain.PaymentDetails;
import org.springframework.http.ResponseEntity;

public interface PaymentController {

    ResponseEntity<Void> processPayment(Long orderId, PaymentDetails paymentDetails);

}
