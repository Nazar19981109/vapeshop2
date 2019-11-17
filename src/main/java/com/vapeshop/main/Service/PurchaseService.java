package com.vapeshop.main.Service;

import com.vapeshop.main.Models.Purchase;
import com.vapeshop.main.Models.Slush;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseService {
    Purchase getById(Integer pid);

    void create(Purchase purchase);

    void deleteById(Integer pid);

    void update(Purchase purchase, Integer pid);

    List<Purchase> getAll();

    void addSlush(Integer pid, Integer slid);

}
