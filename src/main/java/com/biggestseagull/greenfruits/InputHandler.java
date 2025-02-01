package com.biggestseagull.greenfruits;

import java.util.Scanner;

public class InputHandler {

    public static void MenuHandler() {
        // Print main menu
        System.out.println(
                """
                Главное меню: \n
                1: Добавить фрукт \n
                2: Вывести список фруктов \n
                3: Найти самый дорогой фрукт \n
                4: Найти фрукты с истекшим сроком годности \n
                5: Изменить фрукт \n
                6: Удалить фрукт \n
                7: Сохранить список фруктов в файл \n
                8: Загрузить список фруктов из файла \n
                9: Выйти из программы
                """
        );
        
        // Get input from user
        Scanner scanner = new Scanner(System.in);
        String menuOption = scanner.nextLine();

        // Handle input
        switch (menuOption) {
            case "1" ->
                AddFruit();

            case "2" ->
                PrintFruitList();

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

        // Creating new fruit and adding it to the list
        FruitListHandler.AddFruit(name, weight, pricePerKg, shelfLifeDays);

        // Go back to the menu
        MenuHandler();
    }

    private static void PrintFruitList() {
        
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
