package com.example.kostrakanpwt.Models;

public class PutriCardModel {
    public String category;
    public String price;
    public String name;
    public String desc;

    public PutriCardModel(String category, String price, String name, String desc){
        this.category = category;
        this.price = price;
        this.name = name;
        this.desc = desc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
