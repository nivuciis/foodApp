package com.dev.foodapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.foodapp.Entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{
    
}
