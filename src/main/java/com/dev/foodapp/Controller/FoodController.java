package com.dev.foodapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dev.foodapp.Entity.Food;
import com.dev.foodapp.Services.FoodService;

@RestController
@RequestMapping("/api/foods")
public class FoodController {
    
    @Autowired
    private FoodService foodService;

    @GetMapping("/")
    public List<Food> searchAll(){
       return foodService.searchAll();
    }

    @PostMapping("/")
    public Food insert(@RequestBody Food food){
        return foodService.insert(food);
    }
}
