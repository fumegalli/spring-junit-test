package com.in28minutes.springunittest.controller.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ItemRequest {

    @NotNull
    @NotEmpty
    private String name;

    @Min(1)
    private int price;

    @Min(1)
    private int quantity;

    public ItemRequest(@NotNull @NotEmpty String name, @Min(1) int price, @Min(1) int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public ItemRequest() {
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    public int getQuantity() {
        return quantity;
    }

}
