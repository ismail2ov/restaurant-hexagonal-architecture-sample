package com.github.ismail2ov.restaurant.application;

import com.github.ismail2ov.restaurant.domain.KitchenService;
import com.github.ismail2ov.restaurant.domain.MenuService;
import com.github.ismail2ov.restaurant.domain.Order;
import com.github.ismail2ov.restaurant.domain.OrderService;
import com.github.ismail2ov.restaurant.domain.OrderStatus;
import com.github.ismail2ov.restaurant.domain.exception.ItemsNotAvailableException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderUseCase {

    private final OrderService orderService;
    private final MenuService menuService;
    private final KitchenService kitchenService;

    public Order placeOrder(Order orderRequest) {
        boolean allItemsAvailable = menuService.areItemsAvailable(orderRequest.getItems());
        if (!allItemsAvailable) {
            throw new ItemsNotAvailableException("One or more items are not available");
        }

        orderRequest.setStatus(OrderStatus.PENDING);
        Order savedOrder = orderService.createOrder(orderRequest);

        kitchenService.sendOrderToKitchen(savedOrder);

        return savedOrder;
    }

    public Order getOrderById(Long id) {
        return orderService.findOrderById(id);
    }


    public void updateOrderStatus(Long orderId, OrderStatus status) {
        orderService.updateOrderStatus(orderId, status);
    }
}
