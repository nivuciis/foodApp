package com.dev.foodapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.foodapp.DTO.UserClientRequestDTO;
import com.dev.foodapp.Entity.User;
import com.dev.foodapp.Services.UserClientService;

@RestController
@RequestMapping("/api/client")
public class UserClientController {
    
    @Autowired
    private UserClientService userService;


    @PostMapping("/")
    public User insert(@RequestBody UserClientRequestDTO userClDTO){
        return userService.registUser(userClDTO);
    }

}