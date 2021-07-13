package com.codediff.ocr.api.CashFlowManagementAPI.controllers;

import com.codediff.ocr.api.CashFlowManagementAPI.model.Receipt;
import com.codediff.ocr.api.CashFlowManagementAPI.model.User;
import com.codediff.ocr.api.CashFlowManagementAPI.services.UserReceiptService;
import com.codediff.ocr.api.CashFlowManagementAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    User currentUser;

    @Autowired
    UserReceiptService userReceiptService;

    @PostMapping("/login")
    public ResponseEntity<String> newUser(@RequestBody User user, HttpServletResponse response)throws IOException{
        if (userService.getAllUsers().contains(user)){
            return new ResponseEntity<String>("User "+user.getUserName() + "already exist", HttpStatus.IM_USED);
        }
        userService.createUser(user.getUserName());
        currentUser = userService.getUser(user);
        response.sendRedirect("/account");
        return new ResponseEntity<String>("Welcome "+ user.getUserName() +"!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> login(User user, HttpServletResponse response)throws IOException{
        if(userService.getAllUsers().contains(user)){
            response.sendRedirect("/account");
            return new ResponseEntity<String>("Welcome "+ user.getUserName() +"!", HttpStatus.CREATED);
        }
        else{
            return  new ResponseEntity<>(user.getUserName() +"Not Found!", HttpStatus.NOT_FOUND);
        }
    }




    @GetMapping("/Users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("addReceipt")
    public void addReceiptToUser(Long id, Receipt receipt){
        User currentUser = getUserById(id);
        currentUser.getReceipts().add(receipt);
    }

    @PostMapping("removeReceipt")
    public void removeReceiptFromUser(Long id, Receipt receipt){
        User currentUser = getUserById(id);
            currentUser.getReceipts().remove(receipt);
    }





}
