package com.example.test03_vendingmachine;


import java.io.Serializable;

public class VendingDTO implements Serializable {
    private String pdt_name;
    private int cost, qty;


    public VendingDTO(int cost,  int qty) {

        this.cost = cost;
        this.qty = qty;

    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
