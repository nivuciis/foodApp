package com.dev.foodapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.foodapp.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    User findByEmail(String email);
    User findByEmailAndPassRecovery(String email, String passRecovery);
}
