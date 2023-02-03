package com.codecool.service;

import com.codecool.chapters.chapter3_shop.service.DisplayLists;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class InputScanner{

    public static String getInput(String optionsText) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        try {
            System.out.println(" ");
            System.out.print(optionsText);
            input = br.readLine().strip();
        } catch (IOException e) {
            throw new RuntimeException("Unsuccessful reading! Error!");
        }

        if(input.equalsIgnoreCase("inventory")) {
            DisplayLists.displayPlayerInventory(Singleton.getInstance().getGameCharacter());
            return " ";
        } else {
            return input;
        }

    }
}
