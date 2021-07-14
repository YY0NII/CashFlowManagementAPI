package com.codediff.ocr.api.CashFlowManagementAPI.controllers;

import com.codediff.ocr.api.CashFlowManagementAPI.model.Receipt;
import com.codediff.ocr.api.CashFlowManagementAPI.model.User;
import com.codediff.ocr.api.CashFlowManagementAPI.services.UserReceiptService;
import com.codediff.ocr.api.CashFlowManagementAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserReceiptService userReceiptService;

    @CrossOrigin
    @PostMapping("/users")
    public ResponseEntity<String> newUser(@RequestBody User user, HttpServletResponse response) throws IOException {
        if (userService.getAllUsers().contains(user)) {
            return new ResponseEntity<String>("User " + user.getUserName() + "already exist", HttpStatus.IM_USED);
        }
        userService.addUser(user);
        //response.sendRedirect("/account");
        return new ResponseEntity<String>("Welcome " + user.getUserName() + "!", HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<String> login(User user, HttpServletResponse response)throws IOException{
//        if(userService.getAllUsers().contains(user)){
//            response.sendRedirect("/account");
//            return new ResponseEntity<String>("Welcome "+ user.getUserName() +"!", HttpStatus.CREATED);
//        }
//        else{
//            return  new ResponseEntity<>(user.getUserName() +"Not Found!", HttpStatus.NOT_FOUND);
//        }
//    }
//
//
//
    @CrossOrigin
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @CrossOrigin
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @CrossOrigin
    @PostMapping("/users/{id}")
    public void addReceiptToUser(@PathVariable Long id,@RequestBody Receipt receipt){
       userReceiptService.addReceiptToUser(id,receipt);
    }

    @CrossOrigin
    @PostMapping("removeReceipt")
    public void removeReceiptFromUser(Long id, Receipt receipt){
        User currentUser = getUserById(id);
            currentUser.getReceipts().remove(receipt);
    }
}
