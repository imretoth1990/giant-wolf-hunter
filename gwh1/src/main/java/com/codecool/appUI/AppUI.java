package com.codecool.appUI;

import com.codecool.chapters.BackgroundStory;
import com.codecool.chapters.Chapters;
import com.codecool.chapters.chapter3_shop.service.DisplayLists;
import com.codecool.data.GameCharacter;
import com.codecool.service.Choices;
import com.codecool.service.InputScanner;
import com.codecool.service.Printer;

public class AppUI {

    private final int consoleWidth;
    GameCharacter supportingGameCharacter;
    GameCharacter mainGameCharacter;
    String menuSelection;

    public AppUI(GameCharacter support, GameCharacter main, int consoleWidth) {
        this.supportingGameCharacter = support;
        this.mainGameCharacter = main;
        this.menuSelection = "";
        this.consoleWidth = consoleWidth;
    }

    public void runApp() {
        BackgroundStory backgroundStory = new BackgroundStory();

        String menuSelection;

        boolean running = true;

        while(running) {
            Printer.printSimpleText("+  Welcome in the Giant Wolf Hunter 1, dear Adventurer!  +".toUpperCase());
            System.out.println(" ");
            DisplayLists.displayPlayerInventory(mainGameCharacter);
            System.out.println(" ");
            Choices.printOptions("How do you want to continue?", "Start game", "Read background story");

            menuSelection = InputScanner.getInput("Please select an option by typing [A] or [B]: ").toLowerCase();

            switch (menuSelection) {
                case "a":
                    Chapters.runChapters(supportingGameCharacter, mainGameCharacter);
                    running = false;
                    break;
                case "b":
                    backgroundStory.printStory(consoleWidth);
                    InputScanner.getInput("Please type Enter to return to menu: ");
                    break;
                default:
                    while(!menuSelection.equals("a") && !menuSelection.equals("b")) {
                        Printer.printNarrative("Wrong letter! Please enter [A] or [B].");
                        menuSelection = InputScanner.getInput("Please select an option by typing [A] or [B]: ").toLowerCase();
                    }
            }
        }
    }
}

