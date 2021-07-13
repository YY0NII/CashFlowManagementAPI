package com.codediff.ocr.api.CashFlowManagementAPI.services;

import com.codediff.ocr.api.CashFlowManagementAPI.model.Receipt;
import com.codediff.ocr.api.CashFlowManagementAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserReceiptService {
    @Autowired
    User user;

    HashMap<Long, List<Receipt>> usersAndTheirReceipts = new HashMap<>();

    public List<Receipt> getUserReceipts(Long id){
        return usersAndTheirReceipts.get(id);
    }

    public void addUserReceipts(Long id, List<Receipt> receipts){
        usersAndTheirReceipts.put(id,receipts);
    }

    public void addUserReceipts(Long id){
        usersAndTheirReceipts.put(id,null);
    }

}
