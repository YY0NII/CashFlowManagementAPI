package com.codediff.ocr.api.CashFlowManagementAPI.controllers;

import com.codediff.ocr.api.CashFlowManagementAPI.model.Receipt;
import com.codediff.ocr.api.CashFlowManagementAPI.model.User;
import com.codediff.ocr.api.CashFlowManagementAPI.services.UserReceiptItemService;
import com.codediff.ocr.api.CashFlowManagementAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserReceiptItemService userReceiptItemService;

    // NEW USER
    @PostMapping("/users")
    public ResponseEntity<String> newUser(@RequestBody User user, HttpServletResponse response) throws IOException {
        if (userService.getAllUsers().contains(user)) {
            return new ResponseEntity<String>("User " + user.getUserName() + "already exist", HttpStatus.IM_USED);
        }
        userService.addUser(user);
        //response.sendRedirect("/account");
        return new ResponseEntity<String>("Welcome " + user.getUserName() + "!", HttpStatus.CREATED);
    }

    // GET ALL USERS
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    // ADD RECEIPT TO USER
    @PostMapping("/users/{id}")
    public void addReceiptToUser(@PathVariable Long id,@RequestBody Receipt receipt){
       userReceiptItemService.addReceiptToUser(id,receipt);
    }

    //REMOVE RECEIPT FROM USER
    @PostMapping("removeReceipt")
    public void removeReceiptFromUser(Long id, Receipt receipt){
        User currentUser = getUserById(id);
            currentUser.getReceipts().remove(receipt);
    }
}
