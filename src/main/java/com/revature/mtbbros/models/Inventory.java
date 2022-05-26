package com.revature.mtbbros.models;
public class Inventory {
    private String id;
    private String productName;
    private int qty;

    public Inventory(String id, String productName, int qty) {
        this.id = id;
        this.productName = productName;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", qty=" + qty +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}




