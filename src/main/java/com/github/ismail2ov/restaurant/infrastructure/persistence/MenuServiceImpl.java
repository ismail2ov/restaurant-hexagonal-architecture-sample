package com.github.ismail2ov.restaurant.infrastructure.persistence;

import com.github.ismail2ov.restaurant.domain.MenuItem;
import com.github.ismail2ov.restaurant.domain.MenuService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    @Override
    public boolean addMenuItem(MenuItem menuItem) {
        return false;
    }

    @Override
    public boolean updateMenuItem(MenuItem menuItem) {
        return false;
    }

    @Override
    public List<MenuItem> getMenu() {
        return List.of();
    }

    @Override
    public boolean areItemsAvailable(List<MenuItem> items) {
        return false;
    }
}
