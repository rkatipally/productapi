package com.websystique.springmvc.model;

/**
 * Created by raj on 5/16/16.
 */
public class Product {
    private String modelNo;
    private String description;
    private Long quantity;
    private String type;
    private String brand;
    private Double price;


    public Product(String  modelNo, String description, Long quantity, String type, String brand, Double price){
        this.modelNo = modelNo;
        this.description = description;
        this.quantity = quantity;
        this.type = type;
        this.brand = brand;
        this.price = price;
    }


    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
