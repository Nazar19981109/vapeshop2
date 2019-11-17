package com.vapeshop.main.Repository;

import com.vapeshop.main.Models.Slush;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SlushRepository extends JpaRepository<Slush, Integer> {
    List<Slush> getAllByNameAndPrice (String name, Integer price);
    List<Slush> getAllByName(String name);
    List<Slush> getAllByPrice(Integer price);

}
