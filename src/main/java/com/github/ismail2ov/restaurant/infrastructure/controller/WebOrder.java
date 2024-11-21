package com.github.ismail2ov.restaurant.infrastructure.controller;

import com.github.ismail2ov.restaurant.application.OrderUseCase;
import com.github.ismail2ov.restaurant.application.PaymentUseCase;
import com.github.ismail2ov.restaurant.domain.Order;
import com.github.ismail2ov.restaurant.domain.OrderStatus;
import com.github.ismail2ov.restaurant.domain.PaymentService;
import com.github.ismail2ov.restaurant.infrastructure.OrderRequest;
import com.github.ismail2ov.restaurant.domain.PaymentDetails;
import com.github.ismail2ov.restaurant.infrastructure.mapper.OrderMapper;
import com.github.ismail2ov.restaurant.infrastructure.payment.CashPayment;
import com.github.ismail2ov.restaurant.infrastructure.payment.PosPayment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class WebOrder implements OrderController {

    OrderUseCase orderUseCase;
    PaymentUseCase paymentUseCase;
    PosPayment posPayment;
    CashPayment cashPayment;
    OrderMapper mapper;

    @PostMapping("/orders")
    public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest orderRequest) {
        Order newOrder = mapper.map(orderRequest);
        Order order = orderUseCase.placeOrder(newOrder);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PutMapping("/orders/{orderId}/status")
    public ResponseEntity<Void> updateOrderStatus(@PathVariable Long orderId, @RequestParam OrderStatus status) {
        orderUseCase.updateOrderStatus(orderId, status);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/payments/{orderId}")
    public ResponseEntity<Void> processPayment(@PathVariable Long orderId, @RequestBody PaymentDetails paymentDetails) {
        PaymentService paymentService = (paymentDetails.isPosPayment()) ? posPayment : cashPayment;
        paymentUseCase.processPayment(paymentService, orderId, paymentDetails);
        return ResponseEntity.ok().build();
    }
}
