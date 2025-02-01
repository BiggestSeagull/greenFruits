package com.biggestseagull.greenfruits;

import java.util.ArrayList;

public class FruitListHandler {

    static ArrayList<Fruit> fruits = new ArrayList<>();

    public static void AddFruit(String name, int weight, float pricePerKg, int shelfLifeDays) {
        // Creating new object with input data
        Fruit newFruit = new Fruit();
        newFruit.SetName(name);
        newFruit.SetWeight(weight);
        newFruit.SetPricePerKg(pricePerKg);
        newFruit.SetShelfLifeDays(shelfLifeDays);
        newFruit.SetDateAdded();
        
        // Adding to list
        fruits.add(newFruit);
        
    }
}
