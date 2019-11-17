package com.vapeshop.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
public class Purchase  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private Integer totalPrice;
    private Integer amountSlushes;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Shop shop;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "purchase")
    private List<Slush> slushes;

    public List<Slush> getSlushes() {
        return slushes;
    }

    public void setSlushes(List<Slush> slushes) {
        this.slushes = slushes;
    }


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





}
