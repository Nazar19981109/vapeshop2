package com.vapeshop.main.Controller;

import com.vapeshop.main.Models.Purchase;
import com.vapeshop.main.Repository.PurchaseRepository;
import com.vapeshop.main.Service.PurchaseService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseRestController {

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    PurchaseRepository purchaseRepository;

    @GetMapping("/purchase")
    public List<Purchase> getAll() throws NotFoundException {
        List<Purchase> purchases = purchaseService.getAll();
        if(purchases.size()==0){
            throw new NotFoundException("Нема покупок");
        }
        return purchases;
    }

    @PostMapping("/purchase/create")
    public void create(@RequestBody Purchase purchase){
    purchaseService.create(purchase);
}


    @PutMapping("/purchase/{pid}/slush/{slid}")
    public void addSlush(@PathVariable("pid") Integer pid, @PathVariable("slid") Integer slid){
    purchaseService.addSlush(pid, slid);
}



    @GetMapping("/purchase/{pid}")
    public Purchase getOneById(@PathVariable("pid") Integer pid){
    return purchaseService.getById(pid);
}


    @DeleteMapping("/purchase/{pid}")
    public void deleteById(@PathVariable("pid")Integer pid){
        purchaseService.deleteById(pid);
    }

}
