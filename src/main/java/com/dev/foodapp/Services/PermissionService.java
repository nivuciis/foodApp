package com.dev.foodapp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.foodapp.Entity.Permission;
import com.dev.foodapp.Repository.PermissionRepository;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository permRepo;
    //Get
    public List<Permission> searchAll(){
        return permRepo.findAll();
    }

    //Utilizará essa função para o Post e Put
    public Permission insert(Permission perm){
        Permission newPermission = permRepo.saveAndFlush(perm);
        return newPermission;
    }

    //Delete

    public void delete(Long id){
        Permission perm = permRepo.findById(id).get();
        permRepo.delete(perm);
    }
    
}