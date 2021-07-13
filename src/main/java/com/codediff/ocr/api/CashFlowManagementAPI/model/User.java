package com.codediff.ocr.api.CashFlowManagementAPI.model;

import javax.persistence.OneToMany;
import java.util.*;

public class User {
    private String userName;
    private Double budget;
    private Double totalSpent;
    private Long Id;
    private Boolean overSpent;
    private List<Receipt> receipts;

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Boolean getOverSpent() {
        return overSpent;
    }

    public void setOverSpent(Boolean overSpent) {
        this.overSpent = overSpent;
    }

    public void addToSpent(Double expense) {
        totalSpent += expense;
    }

    public void removeFromSpent(Double expense) {
        totalSpent -= expense;
    }

    public void addReceipt(Receipt receipts) {

    }

    public void removeReceipt(Receipt receipts) {

    }


}
