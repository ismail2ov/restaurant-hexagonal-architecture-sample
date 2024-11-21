package com.github.ismail2ov.restaurant.domain;

import java.util.List;

public interface MenuService {

    boolean areItemsAvailable(List<MenuItem> items);
}
