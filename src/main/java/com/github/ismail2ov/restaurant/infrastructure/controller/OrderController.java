package com.github.ismail2ov.restaurant.infrastructure.controller;

import com.github.ismail2ov.restaurant.domain.Order;
import com.github.ismail2ov.restaurant.domain.OrderStatus;
import com.github.ismail2ov.restaurant.infrastructure.OrderRequest;
import org.springframework.http.ResponseEntity;

public interface OrderController {

    ResponseEntity<Order> placeOrder(OrderRequest orderRequest);

    ResponseEntity<Void> updateOrderStatus(Long orderId, OrderStatus status);

    default ResponseEntity<Void> generateResponse(boolean isSuccess) {
        return isSuccess ? ResponseEntity.ok().build() : ResponseEntity.internalServerError().build();
    }
}
