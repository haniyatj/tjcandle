package com.example.tjsillumiwax.Models;
import com.hishd.tinycart.model.Item;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Item,Serializable {

    private String name, img, status;
    private String scent;
     private String des;
    private double price, discount;
    private int stock, id;
    private int quantity;

    public Product() {
        // Empty constructor required for Firebase serialization
    }

    public Product(String name, String img, String status, double price, double discount, int stock, int id,String des,String scent,int quantity) {
        this.name = name;
        this.img = img;
        this.status = status;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.id = id;
        this.des=des;
        this.scent=scent;
        this.quantity=quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScent() {
        return scent;
    }

    public void setScent(String scent) {
        this.scent = scent;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getItemPrice()
    {
        return new BigDecimal(price);
    }

    @Override
    public String getItemName() {
        return null;
    }

}
