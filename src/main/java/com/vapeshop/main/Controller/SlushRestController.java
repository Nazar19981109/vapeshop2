package com.vapeshop.main.Controller;

import com.vapeshop.main.Models.Slush;
import com.vapeshop.main.Repository.ShopRepository;
import com.vapeshop.main.Repository.SlushRepository;
import com.vapeshop.main.Service.SlushService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Page<Slush> getAllSlush(@RequestParam Optional<Integer> page,
                                   @RequestParam Optional<String> sortBy)throws NotFoundException {
        List<Slush>slushes = slushRepository.findAll();
        if(slushes.size()==0)
        {
            throw new NotFoundException("No slushes");
        }
        return slushRepository.findAll(new PageRequest(page.orElse(0),10,
                Sort.Direction.ASC, sortBy.orElse("slid")));
    }



    @PutMapping("/slush/{slid}")
    public void updateById(@PathVariable("slid")Integer slid, @RequestBody Slush slush){
        slushService.update(slush, slid);
    }


    @DeleteMapping("/slush/{slid}")
    public void deleteById(@PathVariable("slid")Integer slid){
        slushRepository.deleteById(slid);
    }


    @GetMapping("/slush/{name}/{price}")
    public Page<Slush> getByNameAndPrice(@PathVariable("name")String name, @PathVariable("price") Integer price,
                                         @RequestParam Optional<Integer> page){
       return slushRepository.getAllByNameAndPrice(name, price, new PageRequest(page.orElse(0),10));
    }

    @GetMapping("/slush/{name}")
    public Page<Slush> getByName(@PathVariable("name") String name, @RequestParam Optional<Integer> page){
        return slushRepository.getAllByName(name, new PageRequest(page.orElse(0),10));
    }

    @GetMapping("/slush/price")
    public Page<Slush> getByPrice(@RequestParam Integer price,
                                  @RequestParam Optional<Integer> page){
        return slushRepository.getAllByPrice(price, new PageRequest(page.orElse(0),10));
    }







}


