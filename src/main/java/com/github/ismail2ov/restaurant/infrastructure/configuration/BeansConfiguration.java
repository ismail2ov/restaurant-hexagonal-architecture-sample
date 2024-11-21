package com.github.ismail2ov.restaurant.infrastructure.configuration;

import com.github.ismail2ov.restaurant.application.OrderUseCase;
import com.github.ismail2ov.restaurant.domain.KitchenService;
import com.github.ismail2ov.restaurant.domain.MenuService;
import com.github.ismail2ov.restaurant.domain.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public OrderUseCase orderUseCase(OrderService orderService, MenuService menuService, KitchenService kitchenService) {
        return new OrderUseCase(orderService, menuService, kitchenService);
    }

}
