package com.vapeshop.main.Repository;

import com.vapeshop.main.Models.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    Page<Shop> findAll(Pageable pageable);
}
