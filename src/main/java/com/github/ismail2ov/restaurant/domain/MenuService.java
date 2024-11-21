package com.github.ismail2ov.restaurant.domain;

import java.util.List;

public interface MenuService {

    boolean addMenuItem(MenuItem menuItem);

    boolean updateMenuItem(MenuItem menuItem);

    List<MenuItem> getMenu();

    boolean areItemsAvailable(List<MenuItem> items);
}
