package com.codediff.ocr.api.CashFlowManagementAPI.services;

import com.codediff.ocr.api.CashFlowManagementAPI.exceptions.UserNotFoundException;
import com.codediff.ocr.api.CashFlowManagementAPI.model.User;
import com.codediff.ocr.api.CashFlowManagementAPI.repos.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public void addUser(User user) {
        userRepo.save(user);
    }


    public User getUserById(Long id){
        return userRepo.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }

    public void deleteUser(Long id){
        User currentUser = userRepo.getById(id);
        userRepo.delete(currentUser);
        //receiptRepo.deleteAllById(currentUser.getReceipts());

    }

    public void addBudgetToUser(Long userId,Double amountAdded){
        User user =userRepo.findById(userId).orElseThrow(()-> new UserNotFoundException(userId));
        user.setBudget(amountAdded);
        userRepo.save(user);
    }
}

