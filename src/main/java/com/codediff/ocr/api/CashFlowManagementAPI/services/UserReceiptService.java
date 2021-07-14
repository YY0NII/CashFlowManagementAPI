package com.codediff.ocr.api.CashFlowManagementAPI.services;

import com.codediff.ocr.api.CashFlowManagementAPI.exceptions.UserNotFoundException;
import com.codediff.ocr.api.CashFlowManagementAPI.model.Receipt;
import com.codediff.ocr.api.CashFlowManagementAPI.model.User;
import com.codediff.ocr.api.CashFlowManagementAPI.repos.ReceiptRepo;
import com.codediff.ocr.api.CashFlowManagementAPI.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserReceiptService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ReceiptRepo receiptRepo;

    public void addReceiptToUser(Long id,Receipt receipt){
        User newUser =userRepo.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        newUser.addReceipt(receipt);
        receipt.setUser(newUser);
        userRepo.save(newUser);
        receiptRepo.save(receipt);
    }

    public void deleteReceiptFromUer(){

    }

}
