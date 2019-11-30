package com.vapeshop.main.Service;

import com.vapeshop.main.Models.Shop;
import com.vapeshop.main.Repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopRepository shopRepository;

    @Override
    public void update(Shop shop, Integer sid) {
      Shop shopToUpdate = shopRepository.getOne(sid);
      shopToUpdate.setName(shop.getName());
      shopToUpdate.setAddress(shop.getAddress());
      shopToUpdate.setParking(shop.getParking());
      shopRepository.save(shopToUpdate);
    }

}
