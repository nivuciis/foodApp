package com.dev.foodapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.foodapp.Entity.User;

public interface UserClientRepository extends JpaRepository<User, Long>{
    
}
