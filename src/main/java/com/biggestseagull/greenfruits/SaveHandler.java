package com.biggestseagull.greenfruits;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import java.util.ArrayList;

import java.io.IOException;

public class SaveHandler {

    public static void saveFile(ArrayList<Fruit> fruits) {
        try {
            FileOutputStream fos = new FileOutputStream("fruitList.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(fruits);
            oos.close();
            
            System.out.println("Успешно сохранено!");
        } catch (IOException ioe) {
            System.out.println("Ошибка сохранения ioe");
        }
    }

    public static void loadFile(ArrayList<Fruit> fruits) {
        try {
            FileInputStream fis = new FileInputStream("fruitList.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Fruit> loadedList = (ArrayList<Fruit>) ois.readObject();
            fruits.addAll(loadedList);
            ois.close();
            
            System.out.println("Успешно загружено!");
        } catch (IOException ioe) {
            System.out.println("Ошибка загрузки ioe");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Ошибка загрузки cnfe");
        }
    }
}
