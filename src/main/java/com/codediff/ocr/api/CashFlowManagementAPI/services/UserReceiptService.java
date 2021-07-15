package com.codediff.ocr.api.CashFlowManagementAPI.services;

import com.codediff.ocr.api.CashFlowManagementAPI.exceptions.UserNotFoundException;
import com.codediff.ocr.api.CashFlowManagementAPI.model.Receipt;
import com.codediff.ocr.api.CashFlowManagementAPI.model.User;
import com.codediff.ocr.api.CashFlowManagementAPI.repos.ReceiptRepo;
import com.codediff.ocr.api.CashFlowManagementAPI.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
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
        User currentUser =userRepo.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        currentUser.addReceipt(receipt);
        receipt.setUserId(currentUser.getId());
        receiptRepo.save(receipt);
    }

    public void deleteReceiptFromUer(Long userId, Long receiptId){
        User currentUser =userRepo.findById(userId).orElseThrow(()-> new UserNotFoundException(userId));
        Receipt currentReceipt = receiptRepo.findById(receiptId).orElseThrow(()-> new UserNotFoundException(receiptId));
        currentUser.removeReceipt(currentReceipt);
        currentReceipt.removeUserId(currentUser.getId());//almost redundant because the receipt will be set to null anyways
        receiptRepo.delete(currentReceipt);
    }
    @Transactional
    public void deleteAllUserReceipts(Long id){
        User currentUser =userRepo.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        receiptRepo.deleteAll(currentUser.getReceipts());
        currentUser.removeAllReceipts();
        System.out.println("hello"+currentUser);

    }


}
