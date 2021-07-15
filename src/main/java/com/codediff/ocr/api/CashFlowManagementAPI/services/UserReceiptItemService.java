package com.codediff.ocr.api.CashFlowManagementAPI.services;

import com.codediff.ocr.api.CashFlowManagementAPI.exceptions.UserNotFoundException;
import com.codediff.ocr.api.CashFlowManagementAPI.model.Item;
import com.codediff.ocr.api.CashFlowManagementAPI.model.Receipt;
import com.codediff.ocr.api.CashFlowManagementAPI.model.User;
import com.codediff.ocr.api.CashFlowManagementAPI.repos.ItemRepo;
import com.codediff.ocr.api.CashFlowManagementAPI.repos.ReceiptRepo;
import com.codediff.ocr.api.CashFlowManagementAPI.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserReceiptItemService {

    @Autowired
    UserService userService;

    @Autowired
    ReceiptService receiptService;

    @Autowired
    ItemService itemService;

    public void addReceiptToUser(Long userId,Receipt receipt){
        User newUser = userService.getUserById(userId);
        newUser.addReceipt(receipt);
        receipt.setUserId(newUser.getId());

        userService.addUser(newUser);
        receiptService.save(receipt);

        // Trying to decide if I should check for null or allow this method to throw an exception
        for (Item i: receipt.getItems()) {
            i.setReceiptId(receipt.getId());
            itemService.save(i);
        }
    }

    public void deleteReceiptFromUer(){

    }

}
