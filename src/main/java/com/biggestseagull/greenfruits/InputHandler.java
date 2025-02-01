package com.biggestseagull.greenfruits;

import java.util.Scanner;

public class InputHandler {

    public static void MenuHandler() {
        Scanner scanner = new Scanner(System.in);
        String menuOption = scanner.nextLine();

        switch (menuOption) {
            case "1" ->
                AddFruit();

            case "2" ->
                GetFruitList();

            case "3" ->
                GetMostExpensive();

            case "4" ->
                GetAllExpired();

            case "5" ->
                EditFruit();

            case "6" ->
                RemoveFruit();

            case "7" ->
                ExportFile();

            case "8" ->
                ImportFile();

            case "9" ->
                ExitProgram();

            default ->
                System.out.println("Введите число от 1 до 9");
        }

        scanner.close();
    }

    private static void AddFruit() {
        Scanner scanner = new Scanner(System.in);

        // Getting data for new fruit
        System.out.println("Введите название фрукта: ");
        String name = scanner.nextLine();

        System.out.println("Введите массу (гр): ");
        int weight = scanner.nextInt();

        System.out.println("Введите стоимость за килограмм: ");
        float pricePerKg = scanner.nextFloat();

        System.out.println("Введите срок годности (дни): ");
        int shelfLifeDays = scanner.nextInt();

        scanner.close();
        
        // Creating new fruit
        
        
        
    }

    private static void GetFruitList() {

    }

    private static void GetMostExpensive() {

    }

    private static void GetAllExpired() {

    }

    private static void EditFruit() {

    }

    private static void RemoveFruit() {

    }

    private static void ExportFile() {

    }

    private static void ImportFile() {

    }

    private static void ExitProgram() {

    }

}
