package com.dev.foodapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender javaMailSender;
    
 
    @Value("${spring.mail.username}")
    private String from;

    public String sendEmail(String destiny, String title, String message){
        try{
            SimpleMailMessage simpleMailMessage  = new SimpleMailMessage();
            simpleMailMessage.setFrom(from);
            simpleMailMessage.setTo(destiny);
            simpleMailMessage.setSubject(title);
            simpleMailMessage.setText(message);
            javaMailSender.send(simpleMailMessage);
            return "Email Enviado";
        }catch(Exception e){
            return "Error";
        }
    }
}
