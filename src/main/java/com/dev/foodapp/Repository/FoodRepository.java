package com.dev.foodapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.foodapp.Entity.Food;

public interface FoodRepository extends JpaRepository<Food,Long>{
    
}
