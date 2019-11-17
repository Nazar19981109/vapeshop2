package com.vapeshop.main.Service;

import com.vapeshop.main.Models.Shop;
import com.vapeshop.main.Models.Slush;
import com.vapeshop.main.Repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopRepository shopRepository;

    @Override
    public List<Shop> getAll() {
        return shopRepository.findAll();
    }

    @Override
    public Shop getById(Integer sid) {
        return shopRepository.getOne(sid);
    }

    @Override
    public void deleteByid(Integer sid) {
        shopRepository.deleteById(sid);
    }

    @Override
    public void create(Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    public void update(Shop shop, Integer sid) {
      Shop shopToUpdate = getById(sid);
      shopToUpdate.setName(shop.getName());
      shopToUpdate.setAddress(shop.getAddress());
      shopToUpdate.setParking(shop.getParking());
      shopRepository.save(shopToUpdate);
    }

}
