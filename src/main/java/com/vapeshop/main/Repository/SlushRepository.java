package com.vapeshop.main.Repository;

import com.vapeshop.main.Models.Slush;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface SlushRepository extends JpaRepository<Slush, Integer> {
    Page<Slush> getAllByNameAndPrice (String name, Integer price, Pageable pageable);
    @Query("select s from Slush s where name like %?1%")
    Page<Slush> getAllByName(String name, Pageable pageable);
    Page<Slush> getAllByPrice(Integer price, Pageable pageable);
    Page<Slush> findAll(Pageable pageable);
}
