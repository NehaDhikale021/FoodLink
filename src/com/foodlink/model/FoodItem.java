package com.foodlink.model;

import java.time.LocalDate;

public class FoodItem {

    private int foodId;
    private String foodName;
    private int quantity;
    private String unit;
    private String foodType;
    private LocalDate expiryDate;

    public FoodItem(String foodName, int quantity, String unit,
                    String foodType, LocalDate expiryDate) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.unit = unit;
        this.foodType = foodType;
        this.expiryDate = expiryDate;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getFoodType() {
        return foodType;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}