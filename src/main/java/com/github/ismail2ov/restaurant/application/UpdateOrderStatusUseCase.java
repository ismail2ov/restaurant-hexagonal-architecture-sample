package com.github.ismail2ov.restaurant.application;

import com.github.ismail2ov.restaurant.domain.Order;
import com.github.ismail2ov.restaurant.domain.OrderService;
import com.github.ismail2ov.restaurant.domain.OrderStatus;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateOrderStatusUseCase implements BiFunction<Long, OrderStatus, Order> {

    private final OrderService orderService;

    @Override
    public Order apply(Long orderId, OrderStatus orderStatus) {
        return orderService.updateOrderStatus(orderId, orderStatus);
    }
}
