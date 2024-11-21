package com.github.ismail2ov.restaurant.infrastructure;

import com.github.ismail2ov.restaurant.domain.MenuItem;
import java.util.List;
import lombok.Data;

@Data
public class OrderRequest {

    private Long id;
    private Long tableId;
    private List<MenuItem> items;
}
