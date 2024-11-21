package com.github.ismail2ov.restaurant.domain;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order createOrder(Order order);

    OrderStatus getOrderStatus(Long orderId);

    Order updateOrderStatus(Long orderId, OrderStatus status);

    List<Order> getAllOrders();

    Optional<Order> findOrderById(Long id);

    Order updateOrderStatus(Order order, OrderStatus orderStatus);
}
