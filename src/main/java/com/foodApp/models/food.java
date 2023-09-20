package com.foodApp.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class food implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String image;
    private Double price;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public String getImage(){
        return this.image;
    }
    public Double getPrice(){
        return this.price;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setImage(String image){
        this.image = image;
    }
    public void setPrice(Double price){
        this.price = price;
    }
}
