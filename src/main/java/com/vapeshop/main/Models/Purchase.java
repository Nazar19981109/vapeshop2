package com.vapeshop.main.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Purchase  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private Integer totalPrice;
    private Integer amountSlushes;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Shop shop;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "purchase")
    private List<Slush> slushes;


    public Purchase() {
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getAmountSlushes() {
        return amountSlushes;
    }

    public void setAmountSlushes(Integer amountSlushes) {
        this.amountSlushes = amountSlushes;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Slush> getSlushes() {
        return slushes;
    }

    public void setSlushes(List<Slush> slushes) {
        this.slushes = slushes;
    }





}
