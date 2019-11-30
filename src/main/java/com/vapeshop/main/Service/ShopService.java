package com.vapeshop.main.Service;

import com.vapeshop.main.Models.Shop;
import org.springframework.stereotype.Service;

@Service
public interface ShopService {

    void update(Shop shop, Integer sid);

}
