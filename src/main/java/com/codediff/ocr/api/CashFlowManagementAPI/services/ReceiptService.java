package com.codediff.ocr.api.CashFlowManagementAPI.services;

import com.codediff.ocr.api.CashFlowManagementAPI.exceptions.UserNotFoundException;
import com.codediff.ocr.api.CashFlowManagementAPI.model.Receipt;
import com.codediff.ocr.api.CashFlowManagementAPI.repos.ReceiptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiptService {

    @Autowired
    ReceiptRepo receiptRepo;

    public void save(Receipt receipt) {
        receiptRepo.save(receipt);
    }

    public Receipt findById(Long receiptId) {
        return receiptRepo.findById(receiptId).orElseThrow(()-> new UserNotFoundException(receiptId));
    }

    public void delete(Receipt currentReceipt) {
        receiptRepo.delete(currentReceipt);
    }

    public void deleteAll(List<Receipt> receipts) {
        receiptRepo.deleteAll(receipts);
    }
}

