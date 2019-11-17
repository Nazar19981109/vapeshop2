package com.vapeshop.main.Repository;

import com.vapeshop.main.Models.Shop;
import com.vapeshop.main.Models.Slush;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    List<Slush> getAllBySid(Integer sid);
}
