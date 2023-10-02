package com.dev.foodapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.foodapp.DTO.UserClientRequestDTO;
import com.dev.foodapp.Entity.User;
import com.dev.foodapp.Repository.UserClientRepository;

@Service
public class UserClientService {
    @Autowired
    private UserClientRepository userRepo;

    @Autowired
    private UserPermissionService userPermService;

    @Autowired
    private EmailService emailService;
    
    public User registUser(UserClientRequestDTO userClientDTO){
        User newUser = new UserClientRequestDTO().turnIntoUser(userClientDTO);
        User user =  userRepo.saveAndFlush(newUser);
        userPermService.linkUserPermissionClient(user);
        emailService.sendEmail(user.getEmail(), "Cadastro no restaurante", "Seu Registro no restaurante foi realizado com sucesso !");
        return user;
    }    

}
