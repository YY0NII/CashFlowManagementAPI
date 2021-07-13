package com.codediff.ocr.api.CashFlowManagementAPI.services;

import com.codediff.ocr.api.CashFlowManagementAPI.model.User;
import com.codediff.ocr.api.CashFlowManagementAPI.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    UserReceiptService userReceiptService;



    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public void addUser(User user) {
            userRepo.save(user);
    }

    public User getUser(User user){
        return userRepo.findById(user.getId()).orElseThrow();
    }

    public void createUser(String userName){
        User user = new User(userName);
        userRepo.save(user);
        userReceiptService.addUserReceipts(user.getId());
    }

    public User getUserById(Long id){
        return userRepo.findById(id).orElseThrow();
    }



}
