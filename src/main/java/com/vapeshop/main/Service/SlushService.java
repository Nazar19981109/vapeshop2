package com.vapeshop.main.Service;

import com.vapeshop.main.Models.Slush;
import org.springframework.stereotype.Service;

@Service
public interface SlushService {

    Slush create(Slush slush, Integer sid);

    void update(Slush slush, Integer slid);

}
