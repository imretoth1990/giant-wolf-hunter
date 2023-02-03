package com.codecool.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.lang3.StringUtils;

public class Choices {
    public static void printOptions(String question, String... arguments) {
        Dotenv dotenv = Dotenv.load();
        int consoleWidth = Integer.parseInt(dotenv.get("CONSOLE_WIDTH"));

        char letter = 'A';

        System.out.println("");
        System.out.println(StringUtils.center(question, consoleWidth));

        for (String choice : arguments) {
            System.out.println(StringUtils.center(letter + ": " + choice, consoleWidth));
            letter++;
        }
    }
}
