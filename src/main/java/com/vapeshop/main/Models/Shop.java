package com.vapeshop.main.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;


    private String address;
    private String name;
    private Boolean parking;





    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy =  "shop")
    private List<Slush> slushes;



    public List<Slush> getSlushes() {
        return slushes;
    }

    public void setSlushes(List<Slush> slushes) {
        this.slushes = slushes;
    }

    public Shop() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getParking() {
        return parking;
    }

    public void setParking(Boolean parking) {
        this.parking = parking;
    }


}
