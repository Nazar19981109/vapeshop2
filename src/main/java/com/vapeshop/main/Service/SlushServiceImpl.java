package com.vapeshop.main.Service;

import com.vapeshop.main.Models.Shop;
import com.vapeshop.main.Models.Slush;
import com.vapeshop.main.Repository.ShopRepository;
import com.vapeshop.main.Repository.SlushRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SlushServiceImpl implements SlushService {

    @Autowired
    SlushRepository slushRepository;

    @Autowired
    ShopRepository shopRepository;


    @Override
    public Slush create(Slush slush, Integer sid) {
        Shop shop1 = shopRepository.getOne(sid);
        slush.setShop(shop1);
        return slushRepository.save(slush);
    }


    @Override
    public void update(Slush slush, Integer slid){
        Slush slushToUpdate = slushRepository.getOne(slid);
        slushToUpdate.setName(slush.getName());
        slushToUpdate.setNikotin(slush.getNikotin());
        slushToUpdate.setPrice(slush.getPrice());
        slushToUpdate.setProducer(slush.getProducer());
        slushToUpdate.setTaste(slush.getTaste());
        slushRepository.save(slushToUpdate);
    }

}
