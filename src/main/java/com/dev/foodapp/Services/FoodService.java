package com.dev.foodapp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.foodapp.Entity.Food;
import com.dev.foodapp.Repository.FoodRepository;

@Service
public class FoodService {
    
    @Autowired
    private FoodRepository foodRepo;
    //Get
    public List<Food> searchAll(){
        return foodRepo.findAll();
    }

    //Utilizará essa função para o Post e Put
    public Food insert(Food food){
        Food newFood = foodRepo.saveAndFlush(food);
        return newFood;
    }

    //Delete

    public void delete(Long id){
        Food food = foodRepo.findById(id).get();
        foodRepo.delete(food);
    }


}
