package com.DevCourses.SpringBoot;

import com.fasterxml.jackson.annotation.JsonProperty;

// POJO (Plain Old Java Object)
public class Order {

    @JsonProperty("c-name") // Bind the JSON request parameter to the object attribute.
    private String customerName;
    private String productName; // The JSON request parameter must be the same as the object attribute.
    private int quantity;

    /* Note:
    -
    {
        "c-name":"Julian",
        "productName":"laptop",
        "quantity":5
    }
    - For HTTP requests with a JSON body to be correctly converted into objects, either the constructor or the setter methods for the attributes must be implemented.
     */

    public Order(String customerName, String productName, int quantity) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}
