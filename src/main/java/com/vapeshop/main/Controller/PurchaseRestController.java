package com.vapeshop.main.Controller;

import com.vapeshop.main.Models.Purchase;
import com.vapeshop.main.Models.Shop;
import com.vapeshop.main.Repository.PurchaseRepository;
import com.vapeshop.main.Service.PurchaseService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PurchaseRestController {

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    PurchaseRepository purchaseRepository;

    @GetMapping("/purchase")
    public Page<Purchase> getAll(@RequestParam Optional<Integer> page,
                                 @RequestParam Optional<String> sortBy,
                                 @RequestParam Optional<String> name) throws NotFoundException {
        List<Purchase> purchases = purchaseRepository.findAll();
        if(purchases.size()==0){
            throw new NotFoundException("Нема покупок");
        }
        return purchaseRepository.findAll(name.orElse("_"), new PageRequest(page.orElse(0),5,
                Sort.Direction.ASC, sortBy.orElse("pid")));
    }


    @PostMapping("/purchase/create")
    public void create(@RequestBody Purchase purchase){
    purchaseRepository.save(purchase);
}

    @PutMapping("/purchase/{pid}")
    public void updateById(@PathVariable("pid") Integer pid, @RequestBody Purchase purchase){
        purchaseService.update(purchase, pid);
    }

    @PutMapping("/purchase/{pid}/slush/{slid}")
    public void addSlush(@PathVariable("pid") Integer pid, @PathVariable("slid") Integer slid){
    purchaseService.addSlush(pid, slid);
}

    @GetMapping("/purchase/{pid}")
    public Purchase getByPid(@PathVariable("pid") Integer pid) {
        return purchaseRepository.getOne(pid);
    }


    @DeleteMapping("/purchase/{pid}")
    public void deleteById(@PathVariable("pid")Integer pid){
        purchaseRepository.deleteById(pid);
    }

}
