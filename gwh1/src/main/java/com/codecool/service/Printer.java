package com.codecool.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.lang3.StringUtils;

public class Printer {

    public static void printLongText(String text, int width) {

        String[] newText = text.split("[*]", 0);
        for (int i = 0; i < newText.length; i++) {
            System.out.println(StringUtils.center(newText[i], width));
        }
    }

    public static void printSimpleText(String text) {
        Dotenv dotenv = Dotenv.load();
        int consoleWidth = Integer.parseInt(dotenv.get("CONSOLE_WIDTH"));

        System.out.println("");
        System.out.println(StringUtils.center(text, consoleWidth));
    }

    public static void printPage(String text) {
        Dotenv dotenv = Dotenv.load();
        int width = Integer.parseInt(dotenv.get("CONSOLE_WIDTH"));

        System.out.println("");
        System.out.println("*".repeat(width));
        printLongText(text, width);
        System.out.println("*".repeat(width));
    }

    public static void printNarrative(String text) {
        Dotenv dotenv = Dotenv.load();
        int width = Integer.parseInt(dotenv.get("CONSOLE_WIDTH"));

        System.out.println("");
        printLongText(text, width);
    }
}
