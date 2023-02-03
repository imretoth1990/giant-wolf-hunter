package com.codecool.service;

import io.github.cdimascio.dotenv.Dotenv;

public class Calculator {

    public static int calculateCenterValue(int characters) {
        Dotenv dotenv = Dotenv.load();
        int width = Integer.parseInt(dotenv.get("CONSOLE_WIDTH"));

        return (width - characters) / 2;
    }

    public static int returnCurrentConsoleWidth() {
        Dotenv dotenv = Dotenv.load();
        return Integer.parseInt(dotenv.get("CONSOLE_WIDTH"));
    }

    public static double calculatePercentage(int percentage, int x) {
        return ((double) percentage/100) * (double) x;
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }
}