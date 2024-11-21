package com.github.ismail2ov.restaurant.infrastructure.mapper;

import com.github.ismail2ov.restaurant.domain.Order;
import com.github.ismail2ov.restaurant.infrastructure.OrderRequest;

public class OrderMapper {

    public Order map(OrderRequest orderRequest) {
        return Order.builder()
            .id(orderRequest.getId())
            .tableId(orderRequest.getTableId())
            .items(orderRequest.getItems())
            .build();
    }
}
