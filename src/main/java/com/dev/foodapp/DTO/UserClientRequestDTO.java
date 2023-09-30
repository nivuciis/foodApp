package com.dev.foodapp.DTO;

import org.springframework.beans.BeanUtils;

import com.dev.foodapp.Entity.User;

import lombok.Data;

@Data
public class UserClientRequestDTO {
    
    private String name;
    private String cpf;
    private String email;
    private String adress;
    private String cep;
     
    public User turnIntoUser(UserClientRequestDTO UserClDTO){
        User user = new User();
        BeanUtils.copyProperties(UserClDTO, user);
        return user;
    }
}
