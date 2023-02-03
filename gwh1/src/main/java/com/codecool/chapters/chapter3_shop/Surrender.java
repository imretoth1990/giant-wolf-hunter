package com.codecool.chapters.chapter3_shop;

import com.codecool.appUI.AppUI;
import com.codecool.data.GameCharacter;
import com.codecool.service.InputScanner;
import com.codecool.service.Printer;
import com.codecool.service.Singleton;
import io.github.cdimascio.dotenv.Dotenv;

public class Surrender {

    public void goHome() {

        Printer.printPage("GAME OVER! * You agree to give your scotch to him, *" +
                                "you become depressed and went home to sleep and try to forget about the whole shame story...");

        String input = InputScanner.getInput("Want to restart the game [yes / no] ?: ").toLowerCase();

        while (!input.equals("yes") && !input.equals("no")) {
            Printer.printSimpleText("Wrong input");
            input = InputScanner.getInput("Want to restart the game [yes / no] ?: ");
        }

        if (input.equals("yes")) {
                restartGame();
        } else {
            System.out.println("Game exits.");
            System.exit(0);
        }
    }

    public void restartGame() {
        Dotenv dotenv = Dotenv.load();
        int consoleWidth = Integer.parseInt(dotenv.get("CONSOLE_WIDTH"));

        GameCharacter john = new GameCharacter("John", 50, 10, 100);
        GameCharacter player = Singleton.instance.gameCharacter;
        player.setHP(50);
        player.setCoins(150);
        player.setAttack(5);
        player.clearWeaponList(player.getWeaponList());

        AppUI ui = new AppUI(john, player, consoleWidth);
        ui.runApp();
    }
}
