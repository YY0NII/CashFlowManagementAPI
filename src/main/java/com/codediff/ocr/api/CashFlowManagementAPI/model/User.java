package com.codediff.ocr.api.CashFlowManagementAPI.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {
    private String userName;
    private Double budget;
    private Double totalSpent;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean overSpent = false;

    @OneToMany(mappedBy = "userId")
    private List<Receipt> receipts;

    private String password;


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
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void addReceipt(Receipt receipt) {
        this.receipts.add(receipt);
    }

    public void removeReceipt(Receipt receipt) {
        this.receipts.remove(receipt);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", budget=" + budget +
                ", totalSpent=" + totalSpent +
                ", id=" + id +
                ", overSpent=" + overSpent +
                ", receipts=" + receipts +
                '}';
    }
}
