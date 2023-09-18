package com.foodApp.models;

public class food {
    private String name;
    private String image;
    private Double price;

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
