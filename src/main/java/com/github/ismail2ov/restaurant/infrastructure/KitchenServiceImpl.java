package com.github.ismail2ov.restaurant.infrastructure;

import com.github.ismail2ov.restaurant.domain.KitchenService;
import com.github.ismail2ov.restaurant.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class KitchenServiceImpl implements KitchenService {

    @Override
    public void sendOrderToKitchen(Order savedOrder) {

    }
}
