package com.github.ismail2ov.restaurant.domain;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    private Long id;
    private Long tableId;
    private List<MenuItem> items;
    OrderStatus status;

}
