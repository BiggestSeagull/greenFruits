package com.biggestseagull.greenfruits;

import java.io.*;

public class GreenFruits {
    
    // I dont know how is this  works
    // Fixes encoding problem for console
    public static void main(String[] args) throws UnsupportedEncodingException  {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        
        System.out.println("Добро пожаловать в систему управления фруктами!");

        InputHandler.MenuHandler();


    }
}
