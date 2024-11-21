package com.github.ismail2ov.restaurant.infrastructure.payment;

import com.github.ismail2ov.restaurant.domain.PaymentService;
import com.github.ismail2ov.restaurant.domain.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class CashPayment implements PaymentService {

    @Override
    public boolean processPayment(Long orderId, PaymentDetails paymentDetails) {
        return false;
    }
}
