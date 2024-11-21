package com.github.ismail2ov.restaurant.application;

import com.github.ismail2ov.restaurant.domain.PaymentDetails;
import com.github.ismail2ov.restaurant.domain.PaymentService;
import java.util.function.BiFunction;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentUseCase implements BiFunction<Long, PaymentDetails, Boolean> {

    private final PaymentService posPayment;
    private final PaymentService cashPayment;

    @Override
    public Boolean apply(Long orderId, PaymentDetails paymentDetails) {
        PaymentService paymentService = (paymentDetails.isPosPayment()) ? posPayment : cashPayment;

        return paymentService.processPayment(orderId, paymentDetails);
    }
}
