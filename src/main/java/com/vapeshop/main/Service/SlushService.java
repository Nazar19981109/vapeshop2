package com.vapeshop.main.Service;

import com.vapeshop.main.Models.Shop;
import com.vapeshop.main.Models.Slush;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SlushService {

    Slush getById(Integer slid);

    Slush create(Slush slush, Integer sid);

    void deleteById(Integer slid);

    List<Slush> getAll();

    void update(Slush slush, Integer slid);



}
