package com.codediff.ocr.api.CashFlowManagementAPI.services;

import com.codediff.ocr.api.CashFlowManagementAPI.model.Item;
import com.codediff.ocr.api.CashFlowManagementAPI.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    ItemRepo itemRepo;

    public void save(Item i) {
        itemRepo.save(i);
    }
}
