package com.company;

public class Stock {

    //static variables for cbCategory Combo Box
    static String CAT_SHOES = "Shoes";
    static String CAT_DRESSES = "Dresses";
    static String CAT_SKIRTS = "Skirts";
    static String CAT_JEANS = "Jeans";
    static String CAT_SWEATS = "Sweats";

    private String code;
    private String category;
    private String description;
    private double price;
    private int amount;

    //setter-getters
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

}
