package com.dev.foodapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.foodapp.Entity.User;
import com.dev.foodapp.Services.UserAdminService;

@RestController
@RequestMapping("/api/user-admin")
public class UserAdminController {
    
    @Autowired
    private UserAdminService userAdminService;


    @PostMapping("/acess-code")
    public String recoveryAcessCode(@RequestBody User user){

        return userAdminService.recoveryCode(user.getEmail());
    }
    @PostMapping("/change-password")
    public String changePassword(@RequestBody User user ){
        return userAdminService.changePassword(user);
    }

}