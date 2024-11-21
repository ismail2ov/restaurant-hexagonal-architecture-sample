package com.github.ismail2ov.restaurant.domain;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);

    OrderStatus getOrderStatus(Long orderId);

    Order updateOrderStatus(Long orderId, OrderStatus status);

    List<Order> getAllOrders();

    Order findOrderById(Long id);
}
