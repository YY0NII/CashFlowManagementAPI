package com.codediff.ocr.api.CashFlowManagementAPI.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private double price;
    private Integer quantity;
    private String name;
    private Receipt receipt;
    private Categories categories;

    public Item() {

    }

    public Item(Long id, double price, Integer quantity, String name) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }
}
