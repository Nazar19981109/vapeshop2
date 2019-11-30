package com.vapeshop.main.Service;

import com.vapeshop.main.Models.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseService {

    void update(Purchase purchase, Integer pid);

    void addSlush(Integer pid, Integer slid);



}
