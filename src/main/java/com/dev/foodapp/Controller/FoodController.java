package com.dev.foodapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @PutMapping("/")
    public Food change(@RequestBody Food food){
        return foodService.insert(food);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        foodService.delete(id);
        return ResponseEntity.ok().build();
    }
}
