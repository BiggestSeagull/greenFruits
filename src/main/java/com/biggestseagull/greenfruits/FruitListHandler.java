package com.biggestseagull.greenfruits;

import java.util.ArrayList;
import java.time.LocalDate;

public class FruitListHandler {

    static ArrayList<Fruit> fruits = new ArrayList<>();

    public static boolean isEmpty() {
        if (fruits.isEmpty()) {
            System.out.println("Список пуст.");
            return true;
        }
        return false;
    }

    // 1 command in menu
    public static void addFruit(String name, int weight, float pricePerKg, int shelfLifeDays) {        // Creating new object with input data
        Fruit newFruit = new Fruit(name, weight, pricePerKg, shelfLifeDays);

        fruits.add(newFruit);
    }

    // 2 command in menu
    public static void printList() {
        // Catch error
        if (isEmpty()) {
            return;
        }

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

            iteration++;
        }
    }

    // 3 command
    public static void printMostExpensive() {
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

        System.out.printf("Самый дорогой фрукт: %s. Стоимость: %f рублей. \n",
                fruits.get(indexOfMostExpensive).getName(), mostExpensive);
    }

    // 4 command
    public static void printAllExpired() {
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
        }
        // Show it if none of the fruits are expired
        if (!isOnceExpired) {
            System.out.println("Нет просроченных фруктов.");
        }
    }

    // 5 command
    public static void editFruit(int fruitIndex, int fieldToEdit, String inputValue) {
        // Catch error
        if (isEmpty()) {
            return;
        }

        Fruit editableFruit = fruits.get(fruitIndex);

        switch (fieldToEdit) {
            case 1 ->
                editableFruit.setName(inputValue);
            case 2 ->
                editableFruit.setWeight(parseInt(inputValue));
            case 3 ->
                editableFruit.setPricePerKg(parseFloat(inputValue));
            case 4 ->
                editableFruit.setShelfLifeDays(parseInt(inputValue));
            default ->
                throw new AssertionError();
        }
    }

    private static int parseInt(String input) {
        int parsedValue;

        try {
            parsedValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new AssertionError();
        }

        return parsedValue;
    }

    private static float parseFloat(String input) {
        float parsedValue;

        try {
            parsedValue = Float.parseFloat(input);
        } catch (NumberFormatException e) {
            throw new AssertionError();
        }

        return parsedValue;
    }

    // 6 command
    public static void removeFromList(int index) {
        fruits.remove(index);
    }

    // 7 command
    public static void exportList() {

    }

    // 8 command
    public static void importList() {

    }
}
