package com.codediff.ocr.api.CashFlowManagementAPI.services;

import com.codediff.ocr.api.CashFlowManagementAPI.model.Receipt;
import com.codediff.ocr.api.CashFlowManagementAPI.repos.ReceiptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService {

    @Autowired
    ReceiptRepo receiptRepo;

    public void save(Receipt receipt) {
        receiptRepo.save(receipt);
    }
}
