package com.biggestseagull.greenfruits;

import java.time.LocalDate;
import java.io.Serializable;

public class Fruit implements Serializable {

    private String name;
    private int weight;
    private float pricePerKg;
    private int shelfLifeDays;
    private final LocalDate DATE_ADDED;
    
    public boolean isExpired() {
        if (LocalDate.now().isAfter(this.DATE_ADDED.plusDays(this.shelfLifeDays))) {
            // Fruit IS expired
            return true;
        } else {
            return false;
        }
    }
    
    public Fruit(String name, int weight, float pricePerKg, int shelfLifeDays){
        this.name = name;
        this.weight = weight;
        this.pricePerKg = pricePerKg;
        this.shelfLifeDays = shelfLifeDays;
        this.DATE_ADDED = LocalDate.now();
    }
    
    public String getName() {
        return this.name;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    public int getWeight() {
        return this.weight;
    }
    public void setWeight(int newWeight) {
        this.weight = newWeight;
    }

    public float getPricePerKg() {
        return this.pricePerKg;
    }
    public void setPricePerKg(float newPrice) {
        this.pricePerKg = newPrice;
    }

    public int getShelfLifeDays() {
        return this.shelfLifeDays;
    }
    public void setShelfLifeDays(int newShelfLifeDays) {
        this.shelfLifeDays = newShelfLifeDays;
    }

    public LocalDate getDateAdded() {
        return this.DATE_ADDED;
    }
}
