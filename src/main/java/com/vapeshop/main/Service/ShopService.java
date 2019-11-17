package com.vapeshop.main.Service;

import com.vapeshop.main.Models.Shop;
import com.vapeshop.main.Models.Slush;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {

    List<Shop> getAll();

    Shop getById(Integer sid);

    void deleteByid(Integer sid);

    void create(Shop shop);

    void update(Shop shop, Integer sid);




}
