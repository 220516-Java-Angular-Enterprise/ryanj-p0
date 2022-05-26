package com.revature.mtbbros.models;

public class UserProfile {
    private String id;
    private String firstName;
    private String lastName;
    private String displayName;
    private String dOB;
    private String shippingAddress;
    private String billingAddress;

    public UserProfile(){

    }

    public UserProfile(String id, String firstName, String lastName, String displayName, String dOB, String shippingAddress, String billingAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.dOB = dOB;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", dOB='" + dOB + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
}
