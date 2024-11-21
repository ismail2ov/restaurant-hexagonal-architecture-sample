package com.github.ismail2ov.restaurant.infrastructure.persistence;

import com.github.ismail2ov.restaurant.domain.Order;
import com.github.ismail2ov.restaurant.domain.OrderService;
import com.github.ismail2ov.restaurant.domain.OrderStatus;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public OrderStatus getOrderStatus(Long orderId) {
        return null;
    }

    @Override
    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return List.of();
    }

    @Override
    public Order findOrderById(Long id) {
        return null;
    }
}
