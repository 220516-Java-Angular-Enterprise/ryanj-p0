package com.revature.mtbbros.models;

public class Product {
    private String productId;
    private String productName;
    private String brand;
    private String description;
    private String price;
    private String onHand;



    public Product() {
        super();
    }

    public Product(String productId, String productName, String brand, String description, String price, String onHand) {
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.onHand = onHand;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOnHand() {
        return onHand;
    }

    public void setOnHand(String onHand) {
        this.onHand = onHand;
    }

    @Override
    public String toString() {
        return "Part: " + productName + "\nBrand: " + brand + "\nDescription: " + description + "\nPrice: " + price + "\nOn-hand: " + onHand;
    }
}
