package com.github.ismail2ov.restaurant.application;

import com.github.ismail2ov.restaurant.domain.Order;
import com.github.ismail2ov.restaurant.domain.OrderService;
import com.github.ismail2ov.restaurant.domain.OrderStatus;
import com.github.ismail2ov.restaurant.domain.WaiterNotificationService;
import com.github.ismail2ov.restaurant.domain.exception.OrderNotFoundException;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderReadyUseCase implements Function<Long, Order> {

    private final OrderService orderService;
    private final WaiterNotificationService waiterNotificationService;

    @Override
    public Order apply(Long orderId) {
        Order order = orderService.findOrderById(orderId)
            .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));

        Order updatedOrder = orderService.updateOrderStatus(order, OrderStatus.READY);

        waiterNotificationService.notifyWaiter(orderId);

        return updatedOrder;
    }
}
