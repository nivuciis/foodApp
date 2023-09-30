package com.dev.foodapp.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.foodapp.Entity.Permission;
import com.dev.foodapp.Entity.User;
import com.dev.foodapp.Entity.UserPermission;
import com.dev.foodapp.Repository.PermissionRepository;
import com.dev.foodapp.Repository.UserPermissionRepository;

@Service
public class UserPermissionService {
    @Autowired
    private UserPermissionRepository userPermRepo;

    @Autowired
    private PermissionRepository permRepo;

    public void linkUserPermissionClient(User user){
        List<Permission> permList = permRepo.findByName("client");
        if(permList.size()>0){
            UserPermission userPerm = new UserPermission();
            userPerm.setUser(user);
            userPerm.setPerm(permList.get(0));

            userPermRepo.saveAndFlush(userPerm);
        }
    }
    
    
}
