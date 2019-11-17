package com.vapeshop.main.Controller;

import com.vapeshop.main.Models.Shop;
import com.vapeshop.main.Models.Slush;
import com.vapeshop.main.Repository.ShopRepository;
import com.vapeshop.main.Repository.SlushRepository;
import com.vapeshop.main.Service.SlushService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class SlushRestController {
    @Autowired
    SlushService slushService;

    @Autowired
    SlushRepository slushRepository;

    @Autowired
    ShopRepository shopRepository;

    @PostMapping("/shop/{sid}/slush")
    public Slush createSlush(@PathVariable("sid")Integer sid, @RequestBody Slush slush){
       return slushService.create(slush, sid);
    }

    @GetMapping("/slush")
    public List<Slush> getAllSlush()throws NotFoundException {
        List<Slush>slushes = slushService.getAll();
        if(slushes.size()==0){
            throw new NotFoundException("Жижів нема");
        }
        return slushes;
    }


    @PutMapping("/slush/{slid}")
    public void updateById(@PathVariable("slid")Integer slid, @RequestBody Slush slush){
        slushService.update(slush, slid);
    }


    @DeleteMapping("/slush/{slid}")
    public void deleteById(@PathVariable("slid")Integer slid){
        slushService.deleteById(slid);
    }


    @GetMapping("/slush/{name}/{price}")
    public List<Slush> getByNameAndPrice(@PathVariable("name")String name, @PathVariable("price") Integer price){
       return slushRepository.getAllByNameAndPrice(name, price);
    }

    @GetMapping("/slush/{name}")
    public List<Slush> getByName(@PathVariable("name") String name){
        return slushRepository.getAllByName(name);
    }

    @GetMapping("/slush/price")
    public List<Slush> getByPrice(@RequestParam Integer price){
        return slushRepository.getAllByPrice(price);
    }







}


