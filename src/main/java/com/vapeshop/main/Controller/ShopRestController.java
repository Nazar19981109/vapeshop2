package com.vapeshop.main.Controller;

import com.vapeshop.main.Models.Shop;
import com.vapeshop.main.Models.Slush;
import com.vapeshop.main.Repository.ShopRepository;
import com.vapeshop.main.Repository.SlushRepository;
import com.vapeshop.main.Service.ShopService;
import com.vapeshop.main.Service.SlushService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShopRestController {

    @Autowired
    ShopService shopService;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    SlushRepository slushRepository;

    @Autowired
    SlushService slushService;


    @GetMapping("/shop")
    public Page<Shop> getAll(@RequestParam Optional<Integer> page,
                             @RequestParam Optional<String> sortBy) throws NotFoundException {
        List<Shop> shops = shopRepository.findAll();
        if(shops.size()==0){
            throw new NotFoundException("Магазинів нема");
        }
        return shopRepository.findAll(new PageRequest(page.orElse(0),5,
                Sort.Direction.ASC, sortBy.orElse("sid")));
    }


    @GetMapping("/shop/{sid}")
    public Shop getBySid(@PathVariable("sid") Integer sid) {
        return shopRepository.getOne(sid);
    }


    @PutMapping("/shop/{sid}")
    public void updateById(@PathVariable("sid") Integer sid, @RequestBody Shop shop){
        shopService.update(shop,sid);
    }


    @DeleteMapping("/shop/{sid}")
    public void deleteById(@PathVariable("sid") Integer sid){
        shopRepository.deleteById(sid);
    }


    @GetMapping("/shop/{sid}/slush")
    public Page<Slush> getSlushByShop(@PathVariable("sid")Integer sid) throws NotFoundException{
        Shop shopSlush = shopRepository.getOne(sid);
        List<Slush> slushes = shopSlush.getSlushes();
        if(slushes.size()==0){
            throw new NotFoundException("Жиж в магазі нема");
        }
        Page<Slush> pages = new PageImpl<Slush>(slushes);
        return pages;
    }

    @PostMapping("/shop/create")
    public void create(@RequestBody Shop shop){
        shopRepository.save(shop);
    }
















}





