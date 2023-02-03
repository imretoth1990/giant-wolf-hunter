package com.codecool;

import com.codecool.appUI.AppUI;
import com.codecool.data.GameCharacter;
import com.codecool.service.Singleton;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;

public class App {
    /**
     * Standard values
     * *
     * Main Character:
     * Max HP: 50
     * Min Attack: 5
     * *
     * Supporting Character:
     * Max HP: 50
     * Min Attack:
     */
    public static void main(String[] args) throws IOException {

        Dotenv dotenv = Dotenv.load();
        int consoleWidth = Integer.parseInt(dotenv.get("CONSOLE_WIDTH"));

        GameCharacter player = new GameCharacter("Player", 50, 5, 150);
        GameCharacter john = new GameCharacter("John", 50, 10, 100);

        Singleton.getInstance(player);

        AppUI ui = new AppUI(john, player, consoleWidth);
        ui.runApp();
    }
}
