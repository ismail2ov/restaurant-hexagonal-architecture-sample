package com.github.ismail2ov.restaurant.infrastructure.persistence;

import com.github.ismail2ov.restaurant.domain.MenuItem;
import com.github.ismail2ov.restaurant.domain.MenuService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    @Override
    public boolean areItemsAvailable(List<MenuItem> items) {
        return false;
    }
}
