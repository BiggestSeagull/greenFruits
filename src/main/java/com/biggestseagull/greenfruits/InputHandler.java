package com.biggestseagull.greenfruits;

import java.util.Scanner;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static void menuHandler() {
        // Print main menu
        System.out.print(
                """
                Главное меню:
                1: Добавить фрукт
                2: Вывести список фруктов
                3: Найти самый дорогой фрукт
                4: Найти фрукты с истекшим сроком годности
                5: Изменить фрукт
                6: Удалить фрукт
                7: Сохранить список фруктов в файл
                8: Загрузить список фруктов из файла
                9: Выйти из программы
                """
        );

        // Get input from user
        String menuOption = scanner.nextLine();

        // Handle input
        switch (menuOption) {
            case "1" ->
                addFruit();

            case "2" ->
                printFruitList();

            case "3" ->
                printMostExpensive();

            case "4" ->
                printAllExpired();

            case "5" ->
                editFruit();

            case "6" ->
                removeFruit();

            case "7" ->
                exportFile();

            case "8" ->
                importFile();

            case "9" ->
                exitProgram();

            default ->
                backToMenu();
        }
    }

    private static void addFruit() {

        // Getting data for new fruit
        System.out.print("Введите название фрукта: ");
        String name = scanner.nextLine();

        System.out.print("Введите массу (гр): ");
        int weight = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите стоимость за килограмм: ");
        float pricePerKg = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Введите срок годности (дни): ");
        int shelfLifeDays = scanner.nextInt();
        scanner.nextLine();

        // Creating new fruit and adding it to the list
        FruitListHandler.addFruit(name, weight, pricePerKg, shelfLifeDays);
        System.out.println("Фрукт добавлен!");

        backToMenu();
    }

    private static void printFruitList() {
        FruitListHandler.printList();

        backToMenu();
    }

    private static void printMostExpensive() {
        FruitListHandler.printMostExpensive();

        backToMenu();
    }

    private static void printAllExpired() {
        FruitListHandler.printAllExpired();

        backToMenu();
    }

    private static void editFruit() {
        int fruitIndex = getFruitInput();

        // Get field
        System.out.println(
                """
                Введите номер поля для изменения:
                1: Название фрукта
                2: Масса
                3: Стоимость за килограмм
                4: Срок годности
                """
        );
        System.out.print("Введите номер поля для редактирования:");
        int fieldIndex = scanner.nextInt();
        scanner.nextLine();

        // Get new value
        System.out.print("Введите новое значение:");
        String newValue = scanner.nextLine();

        // Transfer data to manager
        FruitListHandler.editFruit(fruitIndex, fieldIndex, newValue);

        backToMenu();
    }

    private static void removeFruit() {
        int fruitIndex = getFruitInput();

        FruitListHandler.removeFromList(fruitIndex);

        backToMenu();
    }

    private static void exportFile() {
        FruitListHandler.exportList();
    }

    private static void importFile() {
        FruitListHandler.importList();
    }

    private static void exitProgram() {
        scanner.close();
        System.exit(0);
    }

    private static void backToMenu() {
        System.out.println("Чтобы вернуться, введите 1");

        int goBack;
        while (true) {
            goBack = scanner.nextInt();
            scanner.nextLine();

            if (goBack == 1) {
                menuHandler();
                return;
            } else {
                unknownInputExсeption();
            }
        }
    }

    private static void unknownInputExсeption() {
        System.out.println("Ввод не распознан");
    }

    private static int getFruitInput() {
        if (FruitListHandler.isEmpty()) {
            backToMenu();
        }

        FruitListHandler.printList();

        // Get fruit
        System.out.print("Введите id фрукта:");
        int fruitIndex = scanner.nextInt();
        scanner.nextLine();

        return fruitIndex;
    }
}
