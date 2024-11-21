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

@RequiredArgsConstructor
public class PosOrder implements OrderController, PaymentController {

    private final PlaceOrderUseCase placeOrderUseCase;
    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;
    private final PaymentUseCase paymentUseCase;
    private final OrderMapper mapper;

    @Override
    public ResponseEntity<Order> placeOrder(OrderRequest orderRequest) {
        Order newOrder = mapper.map(orderRequest);
        Order order = placeOrderUseCase.apply(newOrder);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @Override
    public ResponseEntity<Void> updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = updateOrderStatusUseCase.apply(orderId, status);

        return generateResponse(order.getStatus().equals(status));
    }

    @Override
    public ResponseEntity<Void> processPayment(Long orderId, PaymentDetails paymentDetails) {
        boolean isSuccess = paymentUseCase.apply(orderId, paymentDetails);

        return generateResponse((isSuccess));
    }
}
