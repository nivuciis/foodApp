package com.foodApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.foodApp.models.food;

public interface foodRepository extends CrudRepository<food,String>{
    
}
