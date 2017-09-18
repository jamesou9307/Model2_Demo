package com.james.model2.entity;

import java.io.Serializable;

public class Product implements Serializable{

    private  static final long serialVersionUID=748392348L;
    private String productName;
    private float price;
    private String description;

    public Product() {
    }

    public Product(String productName, float price, String description) {
        this.productName = productName;
        this.price = price;
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
