package com.biggestseagull.greenfruits;

import java.time.LocalDate;

public class Fruit {

    private String name;
    private int weight;
    private float pricePerKg;
    private int shelfLifeDays;
    private LocalDate dateAdded;
    
    public boolean isExpired() {
        if (LocalDate.now().isAfter(this.dateAdded.plusDays(this.shelfLifeDays))) {
            // Fruit IS expired
            return true;
        } else {
            return false;
        }
    }
    
    public String getName() {
        return this.name;
    }
    public void SetName(String newName) {
        this.name = newName;
    }

    public int getWeight() {
        return this.weight;
    }
    public void SetWeight(int newWeight) {
        this.weight = newWeight;
    }

    public float getPricePerKg() {
        return this.pricePerKg;
    }
    public void SetPricePerKg(float newPrice) {
        this.pricePerKg = newPrice;
    }

    public int getShelfLifeDays() {
        return this.shelfLifeDays;
    }
    public void SetShelfLifeDays(int newShelfLifeDays) {
        this.shelfLifeDays = newShelfLifeDays;
    }

    public LocalDate getDateAdded() {
        return this.dateAdded;
    }
    public void SetDateAdded() {
        this.dateAdded = LocalDate.now();
    }

    

}
