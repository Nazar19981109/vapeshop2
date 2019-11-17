package com.vapeshop.main.Service;

import com.vapeshop.main.Models.Purchase;
import com.vapeshop.main.Models.Shop;
import com.vapeshop.main.Models.Slush;
import com.vapeshop.main.Repository.PurchaseRepository;
import com.vapeshop.main.Repository.ShopRepository;
import com.vapeshop.main.Repository.SlushRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    SlushRepository slushRepository;

    @Override
    public void create(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    @Override
    public void deleteById(Integer pid) {
        purchaseRepository.deleteById(pid);
    }

    @Override
    public void update(Purchase purchase, Integer pid) {
        Purchase purchaseToUpdate = purchaseRepository.getOne(pid);
        purchaseToUpdate.setTotalPrice(purchase.getTotalPrice());
        purchaseToUpdate.setAmountSlushes(purchase.getAmountSlushes());
        purchaseRepository.save(purchase);
    }

    @Override
    public Purchase getById(Integer pid) {
        return purchaseRepository.getOne(pid);
    }

    @Override
    public List<Purchase> getAll() {
       return purchaseRepository.findAll();
    }

    @Override
    public void addSlush(Integer pid, Integer slid) {
        Slush slush1 = slushRepository.getOne(slid);
        Purchase purchase1 = purchaseRepository.getOne(pid);
        slush1.setPurchase(purchase1);
        purchaseRepository.save(purchase1);
        List<Slush> slushes = purchase1.getSlushes();
        Integer total = 0;
        for(Slush slush : slushes){
            Integer price = slush.getPrice();
            total += price;
        }
        purchase1.setTotalPrice(total);
        purchase1.setAmountSlushes(slushes.size());
        purchase1.setShop(slush1.getShop());
        purchaseRepository.save(purchase1);
        slush1.setShop(null);
        slushRepository.save(slush1);
    }
}
