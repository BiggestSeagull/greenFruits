package com.biggestseagull.greenfruits;

public class GreenFruits {

    public static void main(String[] args) {

        System.out.println("Добро пожаловать в систему управления фруктами!");
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

        InputHandler.MenuHandler();


    }
}
