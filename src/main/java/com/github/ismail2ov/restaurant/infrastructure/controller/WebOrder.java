package com.github.ismail2ov.restaurant.infrastructure.controller;

import com.github.ismail2ov.restaurant.application.PaymentUseCase;
import com.github.ismail2ov.restaurant.application.PlaceOrderUseCase;
import com.github.ismail2ov.restaurant.application.UpdateOrderStatusUseCase;
import com.github.ismail2ov.restaurant.domain.Order;
import com.github.ismail2ov.restaurant.domain.OrderStatus;
import com.github.ismail2ov.restaurant.domain.PaymentDetails;
import com.github.ismail2ov.restaurant.infrastructure.OrderRequest;
import com.github.ismail2ov.restaurant.infrastructure.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class WebOrder implements OrderController, PaymentController {

    private final PlaceOrderUseCase placeOrderUseCase;
    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;
    private final PaymentUseCase paymentUseCase;
    private final OrderMapper mapper;

    @Override
    @PostMapping("/orders")
    public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest orderRequest) {
        Order newOrder = mapper.map(orderRequest);
        Order order = placeOrderUseCase.apply(newOrder);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @Override
    @PutMapping("/orders/{orderId}/status")
    public ResponseEntity<Void> updateOrderStatus(@PathVariable Long orderId, @RequestParam OrderStatus status) {
        Order order = updateOrderStatusUseCase.apply(orderId, status);

        return generateResponse(order.getStatus().equals(status));
    }

    @Override
    @PostMapping("/payments/{orderId}")
    public ResponseEntity<Void> processPayment(@PathVariable Long orderId, @RequestBody PaymentDetails paymentDetails) {
        boolean isSuccess = paymentUseCase.apply(orderId, paymentDetails);

        return generateResponse((isSuccess));
    }

}
