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

import com.dev.foodapp.Entity.Permission;
import com.dev.foodapp.Services.PermissionService;

@RestController
@RequestMapping("/api/perm")
public class PermissionController {
    
    @Autowired
    private PermissionService permServ;

    @GetMapping("/")
    public List<Permission> searchAll(){
       return permServ.searchAll();
    }

    @PostMapping("/")
    public Permission insert(@RequestBody Permission perm){
        return permServ.insert(perm);
    }
    @PutMapping("/")
    public Permission change(@RequestBody Permission perm){
        return permServ.insert(perm);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        permServ.delete(id);
        return ResponseEntity.ok().build();
    }
}