package com.in28minutes.springunittest.controller.response;

import com.in28minutes.springunittest.model.Item;

public class ItemResponse {

    private int id;
    private String name;
    private int price;
    private int quantity;
    private int value;

    public ItemResponse(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.price = item.getPrice();
        this.quantity = item.getQuantity();
    }

    public ItemResponse(int id, String name, int price, int quantity, int value) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
    }

    public ItemResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
