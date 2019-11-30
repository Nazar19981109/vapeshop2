package com.vapeshop.main.Repository;

import com.vapeshop.main.Models.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    @Query("select p from Purchase p where p.shop.name like ?1%")
    Page<Purchase> findAll(String name, Pageable pageable);}

