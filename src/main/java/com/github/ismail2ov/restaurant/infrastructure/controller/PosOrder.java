package com.github.ismail2ov.restaurant.infrastructure.controller;

import com.github.ismail2ov.restaurant.application.OrderUseCase;
import com.github.ismail2ov.restaurant.domain.Order;
import com.github.ismail2ov.restaurant.domain.OrderStatus;
import com.github.ismail2ov.restaurant.infrastructure.OrderRequest;
import com.github.ismail2ov.restaurant.infrastructure.mapper.OrderMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PosOrder implements OrderController {

    OrderUseCase orderUseCase;
    OrderMapper mapper;

    public ResponseEntity<Order> placeOrder(OrderRequest orderRequest) {
        Order newOrder = mapper.map(orderRequest);
        Order order = orderUseCase.placeOrder(newOrder);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    public ResponseEntity<Void> updateOrderStatus(Long orderId, OrderStatus status) {
        orderUseCase.updateOrderStatus(orderId, status);
        return ResponseEntity.ok().build();
    }

}
