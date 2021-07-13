package com.codediff.ocr.api.CashFlowManagementAPI.services;

import com.codediff.ocr.api.CashFlowManagementAPI.model.User;
import com.codediff.ocr.api.CashFlowManagementAPI.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserReceiptService userReceiptService;


    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public void addUser(User user){
        userRepo.save(user);
    }

//    public User getUser(User user){
//        for (User temp : users) {
//
//            if (temp.equals(user)){
//                return temp;
//            }
//        }
//        return  null;
//    }
//
//    public void createUser(String userName){
//        User user = new User(userName);
//        users.add(user);
//        userReceiptService.addUserReceipts(user.getId());
//    }
//
//    public User getUserById(Long id){
//        for (User user: users){
//            if (user.getId().equals(id)){
//                return user;
//            }
//
//        }
//        return null;
//    }
}
