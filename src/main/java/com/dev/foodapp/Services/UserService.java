package com.dev.foodapp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.foodapp.Entity.User;
import com.dev.foodapp.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    //Get
    public List<User> searchAll(){
        return userRepo.findAll();
    }

    //Utilizará essa função para o Post e Put
    public User insert(User user){
        User newUser = userRepo.saveAndFlush(user);
        return newUser;
    }

    //Delete

    public void delete(Long id){
        User user = userRepo.findById(id).get();
        userRepo.delete(user);
    }
    
}
