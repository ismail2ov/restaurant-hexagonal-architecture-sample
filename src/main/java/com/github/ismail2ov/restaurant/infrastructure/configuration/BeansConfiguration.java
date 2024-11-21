package com.github.ismail2ov.restaurant.infrastructure.configuration;

import com.github.ismail2ov.restaurant.application.OrderReadyUseCase;
import com.github.ismail2ov.restaurant.application.PaymentUseCase;
import com.github.ismail2ov.restaurant.application.PlaceOrderUseCase;
import com.github.ismail2ov.restaurant.application.UpdateOrderStatusUseCase;
import com.github.ismail2ov.restaurant.domain.KitchenService;
import com.github.ismail2ov.restaurant.domain.MenuService;
import com.github.ismail2ov.restaurant.domain.OrderService;
import com.github.ismail2ov.restaurant.domain.WaiterNotificationService;
import com.github.ismail2ov.restaurant.infrastructure.mapper.OrderMapper;
import com.github.ismail2ov.restaurant.infrastructure.payment.CashPayment;
import com.github.ismail2ov.restaurant.infrastructure.payment.PosPayment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public PlaceOrderUseCase orderUseCase(OrderService orderService, MenuService menuService, KitchenService kitchenService) {
        return new PlaceOrderUseCase(orderService, menuService, kitchenService);
    }

    @Bean
    public UpdateOrderStatusUseCase updateOrderStatusUseCase(OrderService orderService) {
        return new UpdateOrderStatusUseCase(orderService);
    }

    @Bean
    public PaymentUseCase paymentUseCase(PosPayment posPayment, CashPayment cashPayment) {
        return new PaymentUseCase(posPayment, cashPayment);
    }

    @Bean
    public OrderReadyUseCase orderReadyUseCase(OrderService orderService, WaiterNotificationService waiterNotificationService) {
        return new OrderReadyUseCase(orderService, waiterNotificationService);
    }

    @Bean
    public OrderMapper orderMapper() {
        return new OrderMapper();
    }

}
