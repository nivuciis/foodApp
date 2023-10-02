package com.dev.foodapp.Services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.foodapp.Entity.User;
import com.dev.foodapp.Repository.UserRepository;

@Service
public class UserAdminService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private EmailService emailService;
    
    public String recoveryCode(String email){

        User user = userRepo.findByEmail(email);
        user.setPassRecovery(getPassRecovery(user.getId()));
        user.setValityCode(new Date());
        userRepo.saveAndFlush(user);
        emailService.sendEmail(user.getEmail(), "Codigo de recuperação","O seu código de recuperação é: " +user.getPassRecovery());
        return "Codigo enviado com sucesso !";
    }    

    public String changePassword(User user){
        User userSigned = userRepo.findByEmailAndPassRecovery(user.getEmail(),user.getPassRecovery());
        
        
        if(userSigned != null){    
            Date diference = new Date(new Date().getTime() - userSigned.getValityCode().getTime());
            if(diference.getTime()/1000 < 900){
                userSigned.setPassword(user.getPassword());
                userSigned.setPassRecovery(null);
                userRepo.saveAndFlush(userSigned);
                return "Senha alterada com sucesso !";
            }else{
                return "Tempo excedido!";
            }
        }else{
            return "Email ou código não encontrados";
        }
    
    }

    private String getPassRecovery(Long id){
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date())+id;
    }
}
