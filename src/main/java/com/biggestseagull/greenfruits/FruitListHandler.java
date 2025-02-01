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

    // 3 command
    public static void PrintMostExpensive() {
        // For iterable
        float countedPrice;

        // For output
        float mostExpensive = Float.MIN_VALUE;
        int indexOfMostExpensive = -1;

        for (int i = 0; i < fruits.size(); i++) {
            // Counting value of iterable fruit
            countedPrice = fruits.get(i).getWeight()
                    / 1000f * fruits.get(i).getPricePerKg();

            // Compare prices of iterable and most expensive. Choose the most
            if (countedPrice > mostExpensive) {
                mostExpensive = countedPrice;
                indexOfMostExpensive = i;
            }
        }

        System.out.printf("Самый дорогой фрукт: %s. Стоимость: %f.",
                fruits.get(indexOfMostExpensive).getName(), mostExpensive);
    }
    
    // 4 command
    

}
