package com.revature.mtbbros.models;

public class Cart {
    private String id;
    private int qty;
    private double amountTotal;

    public Cart(String id, int qty, double amountTotal) {
        this.id = id;
        this.qty = qty;
        this.amountTotal = amountTotal;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", qty=" + qty +
                ", amountTotal=" + amountTotal +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(double amountTotal) {
        this.amountTotal = amountTotal;
    }
}
