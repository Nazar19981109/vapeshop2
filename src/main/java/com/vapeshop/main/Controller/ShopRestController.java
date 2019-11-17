package com.vapeshop.main.Controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vapeshop.main.Models.Shop;
import com.vapeshop.main.Models.Slush;
import com.vapeshop.main.Repository.ShopRepository;
import com.vapeshop.main.Repository.SlushRepository;
import com.vapeshop.main.Service.PurchaseService;
import com.vapeshop.main.Service.ShopService;
import com.vapeshop.main.Service.SlushService;
import javassist.NotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Shop> getAll() throws NotFoundException {
        List<Shop> shops = shopService.getAll();
        if(shops.size()==0){
            throw new NotFoundException("Магазинів нема");
        }
        return shops;
    }


    @GetMapping("/shop/{sid}")
    public Shop getBySid(@PathVariable("sid") Integer sid) {
        return shopService.getById(sid);
    }


    @PutMapping("/shop/{sid}")
    public void updateById(@PathVariable("sid") Integer sid, @RequestBody Shop shop){
        shopService.update(shop,sid);
    }


    @DeleteMapping("/shop/{sid}")
    public void deleteById(@PathVariable("sid") Integer sid){
        shopService.deleteByid(sid);
    }


    @GetMapping("/shop/{sid}/slush")
    public List<Slush> getSlushByShop(@PathVariable("sid")Integer sid) throws NotFoundException{
        Shop shopSlush = shopService.getById(sid);
        List<Slush> slushes = shopSlush.getSlushes();
        if(slushes.size()==0){
            throw new NotFoundException("Жиж в магазі нема");
        }
        return slushes;
    }

    @PostMapping("/shop/create")
    public void create(@RequestBody Shop shop){
        shopService.create(shop);
    }
















}





