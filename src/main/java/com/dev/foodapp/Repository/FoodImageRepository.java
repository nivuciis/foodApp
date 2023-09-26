package com.dev.foodapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.foodapp.Entity.FoodImage;

public interface FoodImageRepository extends JpaRepository<FoodImage, Long>{
    
}
