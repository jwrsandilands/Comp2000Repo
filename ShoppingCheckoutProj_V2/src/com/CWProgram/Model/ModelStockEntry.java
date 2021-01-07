package com.CWProgram.Model;

public class ModelStockEntry {
    //table columns
    private int stockNumber;
    private String description;
    private float price;
    private int itemsInStock;
    private int alertLevel;

    //getters
    public int getStockNumber(){
        return stockNumber;
    }

    public String getDescription(){
        return description;
    }

    public float getPrice(){
        return price;
    }

    public int getItemsInStock(){
        return itemsInStock;
    }

    public int getAlertLevel(){
        return alertLevel;
    }

    //setters
    public void setStockNumber(int stockNumber){
        this.stockNumber = stockNumber;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public void setItemsInStock(int itemsInStock){
        this.itemsInStock = itemsInStock;
    }

    public void setAlertLevel(int alertLevel){
        this.alertLevel = alertLevel;
    }
}
