package com.biggestseagull.greenfruits;

import java.util.ArrayList;
import java.time.LocalDate;

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
        int shelfLifeDays;
        LocalDate dateAdded;
        
        boolean isExpired;
        
        int iteration = 0;

        System.out.println("id | Название | Масса, гр | Цена, руб/кг | Срок годности | Дата добавления | Просрочено ");
        for (Fruit fruit : fruits) {
            name = fruit.getName();
            weight = fruit.getWeight();
            pricePerKg = fruit.getPricePerKg();
            shelfLifeDays = fruit.getShelfLifeDays();
            dateAdded = fruit.getDateAdded();
            isExpired = fruit.isExpired();

            
            if (!isExpired) {
                System.out.printf("%d | %s | %d | %f | %d | %s | Нет \n",
                        iteration, name, weight, pricePerKg, shelfLifeDays, dateAdded);
            } else {
                System.out.printf("%d | %s | %d | %f | %d | %s | Да \n",
                        iteration, name, weight, pricePerKg, shelfLifeDays, dateAdded);
            }
            
            iteration ++;
        }

    }

    // 3 command
    public static void PrintMostExpensive() {
        // Catch error
        if (isEmpty()) {
            return;
        }

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
    public static void PrintAllExpired() {
        // Catch error
        if (isEmpty()) {
            return;
        }

        String name;
        boolean isExpired;

        boolean isOnceExpired = false;

        for (int i = 0; i < fruits.size(); i++) {
            name = fruits.get(i).getName();
            isExpired = fruits.get(i).isExpired();

            if (isExpired) {
                // Print title if found expired. Only once
                if (!isOnceExpired) {
                    isOnceExpired = true;
                    System.out.println("Просрочено:");
                }

                System.out.printf("%s. Индекс: %d. \n", name, i);
            }

            // Show it if none of the fruits are expired
            if (!isOnceExpired) {
                System.out.println("Нет просроченных фруктов.");
            }
        }
    }

    // 5 command
    public static void EditFruit(int index) {

    }

    private static boolean isEmpty() {
        if (fruits.isEmpty()) {
            System.out.println("Список пуст.");
            return true;
        }
        return false;
    }

}
