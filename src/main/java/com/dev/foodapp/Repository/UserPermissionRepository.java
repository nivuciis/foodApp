package com.dev.foodapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.foodapp.Entity.UserPermission;

public interface UserPermissionRepository extends JpaRepository<UserPermission, Long>{
    
}
