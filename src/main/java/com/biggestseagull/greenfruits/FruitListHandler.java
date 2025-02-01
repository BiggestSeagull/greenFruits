package com.biggestseagull.greenfruits;

import java.util.ArrayList;

public class FruitListHandler {

    static ArrayList<Fruit> fruits = new ArrayList<>();

    // 1 command in menu
    public static void AddFruit(String name, int weight, float pricePerKg, int shelfLifeDays) {
        // Creating new object with input data
        Fruit newFruit = new Fruit();
        newFruit.SetName(name);
        newFruit.SetWeight(weight);
        newFruit.SetPricePerKg(pricePerKg);
        newFruit.SetShelfLifeDays(shelfLifeDays);
        newFruit.SetDateAdded();

        // Adding to the list
        fruits.add(newFruit);
    }

    // 2 command in menu
    public static void PrintList() {
        String name;
        int weight;
        float pricePerKg;
        boolean isExpired;
        
        for (Fruit fruit : fruits) {
            name = fruit.getName();
            weight = fruit.getWeight();
            pricePerKg = fruit.getPricePerKg();
            isExpired = fruit.isExpired();

            if (!isExpired) {
                System.out.printf("%s массой %d гр. стоит %f за кг. \n",
                        name, weight, pricePerKg);
            } else {
                System.out.printf("Просрочено: %s массой %d гр. стоит %f за кг. \n",
                        name, weight, pricePerKg);
            }
        }
        
        
    }
}
