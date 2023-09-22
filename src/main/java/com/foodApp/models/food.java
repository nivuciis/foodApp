package com.foodApp.models;

import java.io.Serializable;

import org.hibernate.annotations.CollectionIdMutability;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class food implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private Double price;
    @Lob
    @Column(name = "image")
    private byte[] image;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public byte[] getImage(){
        return this.image;
    }
    public Double getPrice(){
        return this.price;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setImage(byte[] image){
        this.image = image;
    }
    public void setPrice(Double price){
        this.price = price;
    }
}
